const wrapper = document.getElementById("nav-show-type");
const buttonApplyFilterEl = document.getElementById("button-apply-filter");
const contentCardEl = document.getElementById("content-card");
const wrapperNav = document.getElementById("navigation-wrapper");

wrapper.addEventListener("click", (e) => {
  const button = e.target;
  const filter = button.dataset.filter;

  if (button.classList.contains("button-apply-filter")) {
    const string = `input[name=${filter}]:checked`;
    const value = document.querySelector(string).value;

    const option = {
      method: "GET",
      credentials: "same-origin", // include, *same-origin, omit
    };

    fetch(
      server_name +
        "/products/get?type=" +
        window.location.href[window.location.href.length - 1] +
        "&value=" +
        value +
        "&filter=" +
        filter,
      option
    )
      .then((res) => {
        if (!res.ok) {
          throw new Error(`Not found(${res.status}`);
        }
        return res.json();
      })
      .then((json) => {
        contentCardEl.innerHTML = "";
        const products = json;
        console.log(products);
        products.map((product) => {
          const el = renderCol(product);
          contentCardEl.innerHTML = contentCardEl.innerHTML + el;
        });
      })
      .catch((err) => console.log(err));
  }
});

wrapperNav.addEventListener("click", (e) => {
  const button = e.target;
  const filter = button.dataset.filter;

  if (button.classList.contains("button-search-filter")) {
    const searchWord = document.getElementById("search-word");
    const value = searchWord.value;
    const option = {
      method: "GET",
      credentials: "same-origin", // include, *same-origin, omit
    };

    fetch(
      server_name +
        "/products/get?type=" +
        "W" +
        "&value=" +
        value +
        "&filter=" +
        filter,
      option
    )
      .then((res) => {
        if (!res.ok) {
          throw new Error(`Not found(${res.status}`);
        }
        return res.json();
      })
      .then((json) => {
        contentCardEl.innerHTML = "";
        const products = json;
        console.log(products);
        products.map((product) => {
          const el = renderCol(product);
          contentCardEl.innerHTML = contentCardEl.innerHTML + el;
        });
      })
      .catch((err) => console.log(err));
  }
});

const renderCol = (
  product
) => `<div class="col-4"><div class="card thumbnail" style="background-color: white !important">
<a
 
  class="zoom-tool"
  href="/products/${product.uuid}"
  title="add to cart"
  ><span class="icon-search"></span> QUICK VIEW</a
>
<img
  class="card-img-top"
  style="min-height: 357px !important"
  src="${product.imageUrlShow}"
  alt="bootstrap ecommerce templates"
/>
<div class="card-body text-center m-1 p-2 border rounded caption">
  <p class="m-0 text-card-new" >
  ${product.name}
  </p>
  <p class="m-0" >
    <strong> $${product.price}</strong>
  </p>
  <h4 class="m-0">
    
    
      <a href="/login" class="btn btn-warning">
        Add to cart
      </a>
  </h4>
  <div class="action-product">
    <a class="float-left" href="#">Add to Wish List </a>
    <a class="float-right" href="#"> Add to Compare </a>
  </div>
</div>
</div></div> `;
