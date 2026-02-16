function greet(city, city2) {
  console.log(this.name + " from " + city2);
}

const user = { name: "Shivam" };

greet.call(user, "Delhi");
greet.apply(user, ["Delhi", "Surat"]);

// const bound = greet.bind(user);
// bound("Delhi");


const promise = new Promise((resolve, reject)=>{
    let success = false;
    if (success) resolve("Done");
    else reject("Error");
});

promise.then(res=>console.log(res)
).catch(err=>console.log(err)
);