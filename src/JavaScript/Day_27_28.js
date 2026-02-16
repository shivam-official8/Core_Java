// const parent = document.querySelector('.parent');
// console.log(parent);
// console.log(parent.children);

// for(let i=0;i<parent.children.length;i++){
//     console.log(parent.children[i].innerHTML);
    
// }
// parent.children[1].style.color="orange";
// console.log(parent.firstElementChild);
// console.log(parent.lastElementChild);
// (async (params) => {
//     await new Promise((res,rej)=>{
//         setTimeout(()=>{console.log("hello");}, 2000
//         )
//     })
// })()
// console.log("async");
// // do {
// //     console.log("hiiio");
// // } while (true)
// for (let i = 0; i < array.length; i++) {
//     const element = array[i];
// }
// console.log(parent.lastElementChild);

// document.getElementById("square").addEventListener("click", (e) => {
//     if( e.target.style.backgroundColor != "red")
//   e.target.style.backgroundColor = "red";
// else  e.target.style.backgroundColor = "blue";
// console.log( e.target.style.backgroundColor);

// });
// setInterval(()=>{
//     const e=document.getElementById("square");
//      if( e.style.backgroundColor != "red")
//   e.style.backgroundColor = "red";
// else  e.style.backgroundColor = "blue";
// // console.log( e.style.backgroundColor);
// }, 1000)

setTimeout(()=>{
  console.log("after 2 sec");
  
}, 2000);


let nums = [1, 2, 3, 4];

nums.map(n => n * 2);      // [2,4,6,8]
nums.filter(n => n > 2);  // [3,4]
nums.reduce((a, b) => a + b, 0); // 10


// Closures
// Function remembers outer variables even after execution
function outer() {
  let count = 0;
  return function inner() {
    count++;
    console.log(count);
  };
}

const fn = outer();
fn(); // 1
fn(); // 2


async function createPost() {
  const res = await fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title: "JS", body: "API" })
  });

  const data = await res.json();
  console.log(data);
}

createPost();



async function getPost() {
  const res = await fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "GET",
    headers: { "Content-Type": "application/json" },
    // body: JSON.stringify({ title: "JS", body: "API" })
  });

  const data = await res.json();
  console.log(data);
}

getPost();



function greet(city) {
  console.log(this.name + " from " + city);
}

const user = { name: "Shivam" };

// call method with that instance 
greet.call(user, "Delhi");
// array of parameters
greet.apply(user, ["Delhi"]);

// bind that instance to the function
const bound = greet.bind(user);
bound("Delhi");
