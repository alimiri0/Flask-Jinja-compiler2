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
