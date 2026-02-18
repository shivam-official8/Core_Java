// // const parent = document.querySelector('.parent');
// // console.log(parent);
// // console.log(parent.children);

// // for(let i=0;i<parent.children.length;i++){
// //     console.log(parent.children[i].innerHTML);
    
// // }
// // parent.children[1].style.color="orange";
// // console.log(parent.firstElementChild);
// // console.log(parent.lastElementChild);
// // (async (params) => {
// //     await new Promise((res,rej)=>{
// //         setTimeout(()=>{console.log("hello");}, 2000
// //         )
// //     })
// // })()
// // console.log("async");
// // // do {
// // //     console.log("hiiio");
// // // } while (true)
// // for (let i = 0; i < array.length; i++) {
// //     const element = array[i];
// // }
// // console.log(parent.lastElementChild);

// // document.getElementById("square").addEventListener("click", (e) => {
// //     if( e.target.style.backgroundColor != "red")
// //   e.target.style.backgroundColor = "red";
// // else  e.target.style.backgroundColor = "blue";
// // console.log( e.target.style.backgroundColor);

// // });
// // setInterval(()=>{
// //     const e=document.getElementById("square");
// //      if( e.style.backgroundColor != "red")
// //   e.style.backgroundColor = "red";
// // else  e.style.backgroundColor = "blue";
// // // console.log( e.style.backgroundColor);
// // }, 1000)

// setTimeout(()=>{
//   console.log("after 2 sec");
  
// }, 2000);



// let nums = [1, 2, 3, 4];

// nums.map(n => n * 2);      // [2,4,6,8]
// nums.filter(n => n > 2);  // [3,4]
// nums.reduce((a, b) => a + b, 0); // 10


// // Closures
// // Function remembers outer variables even after execution
// function outer() {
//   let count = 0;
//   return function inner() {
//     count++;
//     console.log(count);
//   };
// }

// const fn = outer();
// fn(); // 1
// fn(); // 2


// async function createPost() {
//   const res = await fetch("https://jsonplaceholder.typicode.com/posts", {
//     method: "POST",
//     headers: { "Content-Type": "application/json" },
//     body: JSON.stringify({ title: "JS", body: "API" })
//   });

//   const data = await res.json();
//   console.log(data);
// }

// createPost();



// async function getPost() {
//   const res = await fetch("https://jsonplaceholder.typicode.com/posts", {
//     method: "GET",
//     headers: { "Content-Type": "application/json" },
//     // body: JSON.stringify({ title: "JS", body: "API" })
//   });

//   const data = await res.json();
//   console.log(data);
// }

// getPost();



// function greet(city) {
//   console.log(this.name + " from " + city);
// }

// const user = { name: "Shivam" };

// // call method with that instance 
// greet.call(user, "Delhi");
// // array of parameters
// greet.apply(user, ["Delhi"]);

// bind that instance to the function
// const bound = greet.bind(user);
// bound("Delhi");


// const apiFetch = async()=>{
//   const res = await fetch("https://jsonplaceholder.typicode.com/posts",
//     {
//     method: "GET",
//     headers:{ "Content-Type": "application/json" },
//   });

//   const data = await res.json();
//   console.log("=================================================================================================");
  
//   console.log(data);
  
// }

// apiFetch();

// let i=0;
// do {
//   console.log(++i);
  
// } while (i<100);

// let arr=[1,2,3,4,5,3,2,3,4,4,3,2,4,32,3,4,32,2];
// console.log(arr);

// for(let i=0;i<arr.length;i++){
//   for(let j=i;j<arr.length;j++){
//     if(arr[j]<arr[i]){
//       let temp=arr[i];
//       arr[i]=arr[j];
//       arr[j]=temp;
//     }
//   }
// }
// console.log(arr);


// function insertionSort(arr) {
//     for (let i = 1; i < arr.length; i++) {
//         let current = arr[i];
//         let j = i - 1;

//         // Move elements of arr[0..i-1] that are greater than current
//         // to one position ahead of their current position
//         while (j >= 0 && arr[j] > current) {
//             arr[j + 1] = arr[j];
//             j--;
//         }
        
//         // Insert the current element at its correct location
//         arr[j + 1] = current;
//     }
//     return arr;
// }

// // Example usage:
// const data = [12, 11, 13, 5, 6, 1,2,3,5,5,-1,-2];
// console.log(insertionSort(data)); // Output: [5, 6, 11, 12, 13]

// function insertionSort(arr) {
//     for (let i = 1; i < arr.length; i++) {
//         let key = arr[i];      // element to be inserted
//         let j = i - 1;

//         // shift elements greater than key to the right
//         while (j >= 0 && arr[j] > key) {
//             arr[j + 1] = arr[j];
//             j--;
//         }

//         // insert key at correct position
//         arr[j + 1] = key;
//     }
//     return arr;
// }

// Example
let arr = [3,5,2,1,7,8,9,10,21,11,13];
// console.log(insertionSort(arr));



for(let i=1;i<arr.length;i++){
    let key = arr[i];
    let j=i-1;
    while(j>=0 && arr[j]>key){
        arr[j+1]=arr[j];
        j--;
    }
    arr[j+1]=key;

}
console.log(arr);

