package server;

import ast.codegen.CodeGenerator;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class AppServer {
    private List<Map<String, Object>> products;
    private CodeGenerator codegen;
    private int nextId = 4;

    public static void main(String[] args) throws Exception {
        new AppServer().start();
    }

    public void start() throws Exception {
        products = new ArrayList<>();
        products.add(createProduct(1, "Phone", 999, "Latest smartphone with great camera", "phone.jpg"));
        products.add(createProduct(2, "Laptop", 1299, "High-performance laptop for professionals", "laptop.jpg"));
        products.add(createProduct(3, "Tablet", 499, "Lightweight tablet perfect for reading and browsing", "tablet.jpg"));

        codegen = new CodeGenerator(null, null);
        codegen.regenerate(products);

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", this::handleRequest);
        server.setExecutor(null);
        server.start();

        System.out.println("Java HTTP Server started on http://localhost:8080");
        System.out.println("Products are synced with App/generated/app.py and App/generated/templates/");
    }

    private Map<String, Object> createProduct(int id, String name, int price, String details, String image) {
        Map<String, Object> p = new LinkedHashMap<>();
        p.put("id", id);
        p.put("name", name);
        p.put("price", price);
        p.put("details", details);
        p.put("image", image);
        return p;
    }

    private void handleRequest(HttpExchange exchange) throws IOException {
        String path = exchange.getRequestURI().getPath();
        String method = exchange.getRequestMethod().toUpperCase();

        try {
            if ("/".equals(path) && "GET".equals(method)) {
                handleIndex(exchange);
            } else if ("/product".equals(path) && "GET".equals(method)) {
                handleShow(exchange);
            } else if ("/create".equals(path) && "GET".equals(method)) {
                handleCreateForm(exchange);
            } else if ("/create".equals(path) && "POST".equals(method)) {
                handleCreateAction(exchange);
            } else if ("/delete".equals(path) && "POST".equals(method)) {
                handleDeleteAction(exchange);
            } else {
                sendResponse(exchange, 404, "<h1>404 Not Found</h1><a href=\"/\">Back to Home</a>");
            }
        } catch (Exception e) {
            sendResponse(exchange, 500, "<h1>500 Internal Server Error</h1><p>" + e.getMessage() + "</p>");
        }
    }

    // ------------------------------------------------------------
    // GET / — product listing page
    // ------------------------------------------------------------
    private void handleIndex(HttpExchange exchange) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><head><title>Products</title><style>");
        sb.append("*{margin:0;padding:0;box-sizing:border-box}");
        sb.append("body{font-family:Arial,sans-serif;padding:20px;background:#f5f5f5}");
        sb.append("nav{background:#333;padding:10px 20px;margin-bottom:20px;border-radius:6px}");
        sb.append("nav a{color:#fff;text-decoration:none;margin-right:20px;font-size:16px}");
        sb.append("nav a:hover{text-decoration:underline}");
        sb.append("h1{margin-bottom:20px;color:#333}");
        sb.append(".product-card{background:#fff;border-radius:8px;padding:15px;margin-bottom:15px;box-shadow:0 2px 4px rgba(0,0,0,0.1);display:flex;gap:15px;align-items:center}");
        sb.append(".product-card img{width:100px;height:100px;object-fit:cover;border-radius:6px}");
        sb.append(".product-card .info{flex:1}");
        sb.append(".product-card h3{margin-bottom:5px}");
        sb.append(".product-card h3 a{color:#007bff;text-decoration:none}");
        sb.append(".product-card .price{color:#28a745;font-size:18px;font-weight:bold}");
        sb.append(".product-card form{display:inline}");
        sb.append(".btn{display:inline-block;padding:6px 12px;border-radius:4px;text-decoration:none;border:none;cursor:pointer;font-size:14px}");
        sb.append(".btn-danger{background:#dc3545;color:#fff}");
        sb.append(".btn-danger:hover{background:#c82333}");
        sb.append(".btn-primary{background:#007bff;color:#fff;margin-top:20px}");
        sb.append(".btn-primary:hover{background:#0056b3}");
        sb.append("</style></head><body>");
        sb.append("<nav><a href=\"/\">Home</a><a href=\"/create\">Add Product</a></nav>");
        sb.append("<h1>Products</h1>");

        for (Map<String, Object> p : products) {
            int id = (int) p.get("id");
            String name = (String) p.get("name");
            int price = (int) p.get("price");
            String image = (String) p.get("image");
            sb.append("<div class=\"product-card\">");
            sb.append("<img src=\"").append(htmlEscape(image)).append("\" alt=\"").append(htmlEscape(name)).append("\">");
            sb.append("<div class=\"info\">");
            sb.append("<h3><a href=\"/product?id=").append(id).append("\">").append(htmlEscape(name)).append("</a></h3>");
            sb.append("<div class=\"price\">$").append(price).append("</div>");
            sb.append("</div>");
            sb.append("<form method=\"POST\" action=\"/delete?id=").append(id).append("\">");
            sb.append("<button type=\"submit\" class=\"btn btn-danger\">Delete</button>");
            sb.append("</form>");
            sb.append("</div>");
        }

        sb.append("<a href=\"/create\" class=\"btn btn-primary\">Add Product</a>");
        sb.append("</body></html>");
        sendResponse(exchange, 200, sb.toString());
    }

    // ------------------------------------------------------------
    // GET /product?id=<id> — product detail page
    // ------------------------------------------------------------
    private void handleShow(HttpExchange exchange) throws IOException {
        int id = parseIntQuery(exchange, "id", -1);
        Map<String, Object> product = findProductById(id);

        if (product == null) {
            sendResponse(exchange, 404, "<h1>Product Not Found</h1><a href=\"/\">Back to Home</a>");
            return;
        }

        String name = (String) product.get("name");
        int price = (int) product.get("price");
        String details = (String) product.get("details");
        String image = (String) product.get("image");

        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><head><title>").append(htmlEscape(name)).append("</title><style>");
        sb.append("*{margin:0;padding:0;box-sizing:border-box}");
        sb.append("body{font-family:Arial,sans-serif;padding:20px;background:#f5f5f5}");
        sb.append("nav{background:#333;padding:10px 20px;margin-bottom:20px;border-radius:6px}");
        sb.append("nav a{color:#fff;text-decoration:none;margin-right:20px;font-size:16px}");
        sb.append("nav a:hover{text-decoration:underline}");
        sb.append(".product-detail{background:#fff;border-radius:8px;padding:20px;box-shadow:0 2px 4px rgba(0,0,0,0.1);max-width:600px}");
        sb.append(".product-detail img{max-width:100%;border-radius:6px;margin-bottom:15px}");
        sb.append(".product-detail h1{margin-bottom:15px;color:#333}");
        sb.append(".product-detail p{margin-bottom:10px;color:#555}");
        sb.append(".product-detail .price{font-size:24px;color:#28a745;font-weight:bold}");
        sb.append(".actions{margin-top:20px;display:flex;gap:10px}");
        sb.append(".btn{display:inline-block;padding:8px 16px;border-radius:4px;text-decoration:none;border:none;cursor:pointer;font-size:14px}");
        sb.append(".btn-primary{background:#007bff;color:#fff}");
        sb.append(".btn-primary:hover{background:#0056b3}");
        sb.append(".btn-danger{background:#dc3545;color:#fff}");
        sb.append(".btn-danger:hover{background:#c82333}");
        sb.append("</style></head><body>");
        sb.append("<nav><a href=\"/\">Home</a><a href=\"/create\">Add Product</a></nav>");
        sb.append("<div class=\"product-detail\">");
        sb.append("<img src=\"").append(htmlEscape(image)).append("\" alt=\"").append(htmlEscape(name)).append("\">");
        sb.append("<h1>").append(htmlEscape(name)).append("</h1>");
        sb.append("<div class=\"price\">$").append(price).append("</div>");
        sb.append("<p>").append(htmlEscape(details)).append("</p>");
        sb.append("<div class=\"actions\">");
        sb.append("<a href=\"/\" class=\"btn btn-primary\">Back</a>");
        sb.append("<form method=\"POST\" action=\"/delete?id=").append(id).append("\">");
        sb.append("<button type=\"submit\" class=\"btn btn-danger\">Delete</button>");
        sb.append("</form>");
        sb.append("</div></div></body></html>");
        sendResponse(exchange, 200, sb.toString());
    }

    // ------------------------------------------------------------
    // GET /create — add product form
    // ------------------------------------------------------------
    private void handleCreateForm(HttpExchange exchange) throws IOException {
        String html = """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Create Product</title>
                <style>
                    *{margin:0;padding:0;box-sizing:border-box}
                    body{font-family:Arial,sans-serif;padding:20px;background:#f5f5f5}
                    nav{background:#333;padding:10px 20px;margin-bottom:20px;border-radius:6px}
                    nav a{color:#fff;text-decoration:none;margin-right:20px;font-size:16px}
                    nav a:hover{text-decoration:underline}
                    h1{margin-bottom:20px;color:#333}
                    form{background:#fff;padding:20px;border-radius:8px;box-shadow:0 2px 4px rgba(0,0,0,0.1);max-width:400px}
                    label{display:block;margin-bottom:5px;color:#555;font-weight:bold}
                    input,textarea{width:100%;padding:8px;margin-bottom:15px;border:1px solid #ddd;border-radius:4px;font-size:14px}
                    textarea{height:80px;resize:vertical}
                    .btn{display:inline-block;padding:8px 16px;border-radius:4px;text-decoration:none;border:none;cursor:pointer;font-size:14px}
                    .btn-primary{background:#007bff;color:#fff}
                    .btn-primary:hover{background:#0056b3}
                    .btn-secondary{background:#6c757d;color:#fff;margin-left:10px}
                    .btn-secondary:hover{background:#5a6268}
                    .actions{display:flex;align-items:center}
                </style>
            </head>
            <body>
                <nav><a href="/">Home</a><a href="/create">Add Product</a></nav>
                <h1>Create Product</h1>
                <form method="POST" action="/create">
                    <label for="name">Name:</label>
                    <input type="text" name="name" id="name" placeholder="Product name" required>
                    <label for="price">Price:</label>
                    <input type="number" name="price" id="price" placeholder="Price" required>
                    <label for="details">Details:</label>
                    <textarea name="details" id="details" placeholder="Product details"></textarea>
                    <label for="image">Image URL:</label>
                    <input type="text" name="image" id="image" placeholder="image.jpg">
                    <div class="actions">
                        <button type="submit" class="btn btn-primary">Save</button>
                        <a href="/" class="btn btn-secondary">Cancel</a>
                    </div>
                </form>
            </body>
            </html>
            """;
        sendResponse(exchange, 200, html);
    }

    // ------------------------------------------------------------
    // POST /create — add product and regenerate
    // ------------------------------------------------------------
    private void handleCreateAction(HttpExchange exchange) throws IOException {
        Map<String, String> formData = parseFormData(exchange);

        String name = formData.getOrDefault("name", "Unnamed Product");
        String priceStr = formData.getOrDefault("price", "0");
        String details = formData.getOrDefault("details", "");
        String image = formData.getOrDefault("image", "default.jpg");

        int price;
        try {
            price = Integer.parseInt(priceStr);
        } catch (NumberFormatException e) {
            price = 0;
        }

        Map<String, Object> newProduct = createProduct(nextId++, name, price, details, image);
        products.add(newProduct);

        codegen.regenerate(products);

        redirect(exchange, "/");
    }

    // ------------------------------------------------------------
    // POST /delete?id=<id> — remove product and regenerate
    // ------------------------------------------------------------
    private void handleDeleteAction(HttpExchange exchange) throws IOException {
        int id = parseIntQuery(exchange, "id", -1);
        products.removeIf(p -> (int) p.get("id") == id);

        codegen.regenerate(products);

        redirect(exchange, "/");
    }

    // ================================================================
    // HELPERS
    // ================================================================

    private Map<String, String> parseFormData(HttpExchange exchange) throws IOException {
        String body = new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
        Map<String, String> params = new HashMap<>();
        if (body.isEmpty()) return params;
        for (String pair : body.split("&")) {
            String[] kv = pair.split("=", 2);
            if (kv.length == 2) {
                params.put(URLDecoder.decode(kv[0], "UTF-8"), URLDecoder.decode(kv[1], "UTF-8"));
            }
        }
        return params;
    }

    private int parseIntQuery(HttpExchange exchange, String key, int defaultVal) {
        String query = exchange.getRequestURI().getQuery();
        if (query == null) return defaultVal;
        for (String pair : query.split("&")) {
            String[] kv = pair.split("=", 2);
            if (kv.length == 2 && kv[0].equals(key)) {
                try {
                    return Integer.parseInt(kv[1]);
                } catch (NumberFormatException e) {
                    return defaultVal;
                }
            }
        }
        return defaultVal;
    }

    private Map<String, Object> findProductById(int id) {
        for (Map<String, Object> p : products) {
            if ((int) p.get("id") == id) return p;
        }
        return null;
    }

    private void redirect(HttpExchange exchange, String location) throws IOException {
        exchange.getResponseHeaders().add("Location", location);
        exchange.sendResponseHeaders(302, -1);
        exchange.getResponseBody().close();
    }

    private void sendResponse(HttpExchange exchange, int status, String body) throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
        exchange.sendResponseHeaders(status, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }

    private String htmlEscape(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#39;");
    }
}
