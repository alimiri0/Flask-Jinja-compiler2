package ast.codegen;

import ast.flask.FlaskASTNode;
import ast.template.TemplateASTNode;
import java.io.*;
import java.util.*;

public class CodeGenerator {
    private FlaskASTNode flaskAST;
    private Map<String, TemplateASTNode> templateASTs;
    private String outputDir = "App/generated";
    private String templatesDir = outputDir + "/templates";

    public CodeGenerator(FlaskASTNode flaskAST, Map<String, TemplateASTNode> templateASTs) {
        this.flaskAST = flaskAST;
        this.templateASTs = templateASTs;
    }

    public void generate() throws IOException {
        new File(templatesDir).mkdirs();
        generateAppPy();
        generateIndexHtml();
        generateShowHtml();
        generateCreateHtml();
        generateDeleteHtml();
    }

    private void generateAppPy() throws IOException {
        try (FileWriter fw = new FileWriter(outputDir + "/app.py")) {
            fw.write("""
from flask import Flask, request, redirect, url_for, render_template

app = Flask(__name__)

products = [
    {"id": 1, "name": "Phone", "price": 999, "details": "Latest smartphone with great camera", "image": "phone.jpg"},
    {"id": 2, "name": "Laptop", "price": 1299, "details": "High-performance laptop for professionals", "image": "laptop.jpg"},
    {"id": 3, "name": "Tablet", "price": 499, "details": "Lightweight tablet perfect for reading and browsing", "image": "tablet.jpg"}
]


@app.route("/")
def index():
    return render_template("index.html", products=products)


@app.route("/product/<int:pid>")
def show(pid):
    product = next((p for p in products if p["id"] == pid), None)
    return render_template("show.html", product=product)


@app.route("/create", methods=["GET", "POST"])
def create():
    if request.method == "POST":
        new_id = len(products) + 1
        new_product = {
            "id": new_id,
            "name": request.form["name"],
            "price": int(request.form["price"]),
            "details": request.form["details"],
            "image": request.form["image"]
        }
        products.append(new_product)
        return redirect(url_for("index"))
    return render_template("create.html")


@app.route("/delete/<int:pid>", methods=["POST"])
def delete(pid):
    global products
    products = [p for p in products if p["id"] != pid]
    return redirect(url_for("index"))


if __name__ == "__main__":
    app.run(debug=True)
""");
        }
    }

    private void generateIndexHtml() throws IOException {
        try (FileWriter fw = new FileWriter(templatesDir + "/index.html")) {
            fw.write("""
<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: Arial, sans-serif; padding: 20px; background: #f5f5f5; }
        nav { background: #333; padding: 10px 20px; margin-bottom: 20px; border-radius: 6px; }
        nav a { color: #fff; text-decoration: none; margin-right: 20px; font-size: 16px; }
        nav a:hover { text-decoration: underline; }
        h1 { margin-bottom: 20px; color: #333; }
        .product-card { background: #fff; border-radius: 8px; padding: 15px; margin-bottom: 15px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); display: flex; gap: 15px; align-items: center; }
        .product-card img { width: 100px; height: 100px; object-fit: cover; border-radius: 6px; }
        .product-card .info { flex: 1; }
        .product-card h3 { margin-bottom: 5px; }
        .product-card h3 a { color: #007bff; text-decoration: none; }
        .product-card h3 a:hover { text-decoration: underline; }
        .product-card .price { color: #28a745; font-size: 18px; font-weight: bold; }
        .product-card form { display: inline; }
        .btn { display: inline-block; padding: 6px 12px; border-radius: 4px; text-decoration: none; border: none; cursor: pointer; font-size: 14px; }
        .btn-danger { background: #dc3545; color: #fff; }
        .btn-primary { background: #007bff; color: #fff; margin-top: 20px; }
        .btn-primary:hover { background: #0056b3; }
        .btn-danger:hover { background: #c82333; }
    </style>
</head>
<body>
    <nav>
        <a href="{{ url_for('index') }}">Home</a>
        <a href="{{ url_for('create') }}">Add Product</a>
    </nav>
    <h1>Products</h1>
    {% for p in products %}
    <div class="product-card">
        <img src="{{ p.image }}" alt="{{ p.name }}">
        <div class="info">
            <h3><a href="{{ url_for('show', pid=p.id) }}">{{ p.name }}</a></h3>
            <div class="price">${{ p.price }}</div>
        </div>
        <form method="POST" action="{{ url_for('delete', pid=p.id) }}">
            <button type="submit" class="btn btn-danger">Delete</button>
        </form>
    </div>
    {% endfor %}
    <a href="{{ url_for('create') }}" class="btn btn-primary">Add Product</a>
</body>
</html>
""");
        }
    }

    private void generateShowHtml() throws IOException {
        try (FileWriter fw = new FileWriter(templatesDir + "/show.html")) {
            fw.write("""
<!DOCTYPE html>
<html>
<head>
    <title>{{ product.name }}</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: Arial, sans-serif; padding: 20px; background: #f5f5f5; }
        nav { background: #333; padding: 10px 20px; margin-bottom: 20px; border-radius: 6px; }
        nav a { color: #fff; text-decoration: none; margin-right: 20px; font-size: 16px; }
        nav a:hover { text-decoration: underline; }
        .product-detail { background: #fff; border-radius: 8px; padding: 20px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); max-width: 600px; }
        .product-detail img { max-width: 100%; border-radius: 6px; margin-bottom: 15px; }
        .product-detail h1 { margin-bottom: 15px; color: #333; }
        .product-detail p { margin-bottom: 10px; color: #555; }
        .product-detail .price { font-size: 24px; color: #28a745; font-weight: bold; }
        .actions { margin-top: 20px; display: flex; gap: 10px; }
        .btn { display: inline-block; padding: 8px 16px; border-radius: 4px; text-decoration: none; border: none; cursor: pointer; font-size: 14px; }
        .btn-primary { background: #007bff; color: #fff; }
        .btn-primary:hover { background: #0056b3; }
        .btn-danger { background: #dc3545; color: #fff; }
        .btn-danger:hover { background: #c82333; }
    </style>
</head>
<body>
    <nav>
        <a href="{{ url_for('index') }}">Home</a>
        <a href="{{ url_for('create') }}">Add Product</a>
    </nav>
    <div class="product-detail">
        <img src="{{ product.image }}" alt="{{ product.name }}">
        <h1>{{ product.name }}</h1>
        <div class="price">${{ product.price }}</div>
        <p>{{ product.details }}</p>
        <div class="actions">
            <a href="{{ url_for('index') }}" class="btn btn-primary">Back</a>
            <form method="POST" action="{{ url_for('delete', pid=product.id) }}">
                <button type="submit" class="btn btn-danger">Delete</button>
            </form>
        </div>
    </div>
</body>
</html>
""");
        }
    }

    private void generateCreateHtml() throws IOException {
        try (FileWriter fw = new FileWriter(templatesDir + "/create.html")) {
            fw.write("""
<!DOCTYPE html>
<html>
<head>
    <title>Create Product</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: Arial, sans-serif; padding: 20px; background: #f5f5f5; }
        nav { background: #333; padding: 10px 20px; margin-bottom: 20px; border-radius: 6px; }
        nav a { color: #fff; text-decoration: none; margin-right: 20px; font-size: 16px; }
        nav a:hover { text-decoration: underline; }
        h1 { margin-bottom: 20px; color: #333; }
        form { background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); max-width: 400px; }
        label { display: block; margin-bottom: 5px; color: #555; font-weight: bold; }
        input, textarea { width: 100%; padding: 8px; margin-bottom: 15px; border: 1px solid #ddd; border-radius: 4px; font-size: 14px; }
        textarea { height: 80px; resize: vertical; }
        .btn { display: inline-block; padding: 8px 16px; border-radius: 4px; text-decoration: none; border: none; cursor: pointer; font-size: 14px; }
        .btn-primary { background: #007bff; color: #fff; }
        .btn-primary:hover { background: #0056b3; }
        .btn-secondary { background: #6c757d; color: #fff; margin-left: 10px; }
        .btn-secondary:hover { background: #5a6268; }
        .actions { display: flex; align-items: center; }
    </style>
</head>
<body>
    <nav>
        <a href="{{ url_for('index') }}">Home</a>
        <a href="{{ url_for('create') }}">Add Product</a>
    </nav>
    <h1>Create Product</h1>
    <form method="POST" action="{{ url_for('create') }}">
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
            <a href="{{ url_for('index') }}" class="btn btn-secondary">Cancel</a>
        </div>
    </form>
</body>
</html>
""");
        }
    }

    private void generateDeleteHtml() throws IOException {
        try (FileWriter fw = new FileWriter(templatesDir + "/delete.html")) {
            fw.write("""
<!DOCTYPE html>
<html>
<head>
    <title>Delete Product</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: Arial, sans-serif; padding: 20px; background: #f5f5f5; }
        nav { background: #333; padding: 10px 20px; margin-bottom: 20px; border-radius: 6px; }
        nav a { color: #fff; text-decoration: none; margin-right: 20px; font-size: 16px; }
        nav a:hover { text-decoration: underline; }
        .confirm-box { background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); max-width: 400px; text-align: center; }
        h1 { margin-bottom: 15px; color: #333; }
        p { margin-bottom: 20px; color: #555; }
        .btn { display: inline-block; padding: 8px 16px; border-radius: 4px; text-decoration: none; border: none; cursor: pointer; font-size: 14px; }
        .btn-danger { background: #dc3545; color: #fff; }
        .btn-danger:hover { background: #c82333; }
        .btn-secondary { background: #6c757d; color: #fff; margin-left: 10px; }
        .btn-secondary:hover { background: #5a6268; }
        .actions { display: flex; justify-content: center; align-items: center; }
    </style>
</head>
<body>
    <nav>
        <a href="{{ url_for('index') }}">Home</a>
        <a href="{{ url_for('create') }}">Add Product</a>
    </nav>
    <div class="confirm-box">
        <h1>Delete Product</h1>
        <p>Are you sure you want to delete this product?</p>
        <div class="actions">
            <form method="POST" action="{{ url_for('delete', pid=product.id) }}">
                <button type="submit" class="btn btn-danger">Confirm Delete</button>
            </form>
            <a href="{{ url_for('index') }}" class="btn btn-secondary">Cancel</a>
        </div>
    </div>
</body>
</html>
""");
        }
    }
}
