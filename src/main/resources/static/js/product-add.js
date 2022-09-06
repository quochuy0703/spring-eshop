console.log("hello");

const fileReader = new FileReader();

const fileUpload = document.getElementById("fileUpload");
const imageHolder = document.getElementById("imageHolder");
fileUpload.addEventListener("change", (e) => {
  const file = e.target.files;
  console.log(file);

  //   fileReader.readAsDataURL(file[0]);
  //   fileReader.addEventListener("load", (e) => {
  //     const img = document.createElement("img");
  //     imageHolder.appendChild(img);
  //     img.src = e.target.result;
  //     img.alt = file[0].name;
  //   });
});
