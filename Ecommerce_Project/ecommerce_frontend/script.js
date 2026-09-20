const API_URL = "http://localhost:8080";

let products = [];
let cart = [];


// ================= LOAD PRODUCTS =================


loadProducts();
loadOrders();

function loadProducts() {

    fetch(`${API_URL}/products`)
        .then(response => response.json())
        .then(data => {

            products = data;

            displayProducts(products);

        })
        .catch(error => {

            console.error("Error loading products:", error);

            document.getElementById("product-list").innerHTML = `
                <p class="loading">
                    Unable to load products.
                    Make sure Spring Boot is running.
                </p>
            `;

        });
}


// ================= DISPLAY PRODUCTS =================

function displayProducts(productList) {

    const container =
        document.getElementById("product-list");

    container.innerHTML = "";


    if (productList.length === 0) {

        container.innerHTML = `
            <p class="loading">
                No products found.
            </p>
        `;

        return;
    }


    productList.forEach(product => {

        const card =
            document.createElement("div");

        card.className = "product-card";


        card.innerHTML = `

            <div class="product-image">
                🛍️
            </div>

            <h3>
                ${product.name}
            </h3>

            <p class="product-description">
                ${product.description}
            </p>

            <p class="product-price">
                ₹${product.price}
            </p>

            <p class="product-stock">
                ${product.stock} items available
            </p>

            <button
                onclick="addToCart(${product.id})">
                Add to Cart
            </button>

        `;


        container.appendChild(card);

    });
}


// ================= SEARCH =================

function searchProducts() {

    const searchValue =
        document
            .getElementById("search-input")
            .value
            .toLowerCase();


    const filteredProducts =
        products.filter(product =>
            product.name
                .toLowerCase()
                .includes(searchValue)
        );


    displayProducts(filteredProducts);
}


// ================= ADD TO CART =================

function addToCart(productId) {

    const product =
        products.find(p => p.id === productId);


    if (!product) {
        return;
    }


    cart.push(product);


    updateCart();


    alert(`${product.name} added to cart`);
}


// ================= UPDATE CART =================

function updateCart() {

    const cartContainer =
        document.getElementById("cart-items");


    const cartCount =
        document.getElementById("cart-count");


    cartCount.textContent = cart.length;


    if (cart.length === 0) {

        cartContainer.innerHTML = `

            <div class="empty-cart">

                <div class="empty-cart-icon">
                    🛒
                </div>

                <h3>
                    Your cart is empty
                </h3>

                <p>
                    Add some products to get started.
                </p>

            </div>

        `;

        document.getElementById("cart-total")
            .textContent = "Total: ₹0";

        return;
    }


    cartContainer.innerHTML = "";


    let total = 0;


    cart.forEach((product, index) => {

        total += product.price;


        const item =
            document.createElement("div");

        item.className = "cart-item";


        item.innerHTML = `

            <div class="cart-item-info">

                <h3>
                    ${product.name}
                </h3>

                <p>
                    ₹${product.price}
                </p>

            </div>

            <button
                class="remove-button"
                onclick="removeFromCart(${index})">

                Remove

            </button>

        `;


        cartContainer.appendChild(item);

    });


    document.getElementById("cart-total")
        .textContent = `Total: ₹${total}`;
}


// ================= REMOVE FROM CART =================

function removeFromCart(index) {

    cart.splice(index, 1);

    updateCart();
}


// ================= PLACE ORDER =================

function placeOrder() {

    if (cart.length === 0) {

        alert("Your cart is empty.");

        return;
    }


    alert(
        "Order feature will be connected to Spring Boot next."
    );
}
function loadOrders() {

    fetch(`${API_URL}/orders`)
        .then(response => response.json())
        .then(data => {

            const orderList =
                document.getElementById("order-list");

            orderList.innerHTML = "";

            if (data.length === 0) {

                orderList.innerHTML = `
                    <div class="empty-order">
                        <div>📦</div>
                        <h3>No orders yet</h3>
                        <p>Your orders will appear here.</p>
                    </div>
                `;

                return;
            }

            data.forEach(order => {

                const orderCard =
                    document.createElement("div");

                orderCard.className = "order-card";

                orderCard.innerHTML = `
                    <h3>Order #${order.id}</h3>

                    <p>
                        Total Amount:
                        <strong>₹${order.totalAmount}</strong>
                    </p>

                    <p>
                        Status:
                        <strong>${order.status}</strong>
                    </p>
                `;

                orderList.appendChild(orderCard);

            });

        })
        .catch(error => {

            console.error("Error loading orders:", error);

        });
}