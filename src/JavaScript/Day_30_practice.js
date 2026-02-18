function add(){
    const inp = document.getElementById("input");
    console.log(inp.value);
    const ul = document.getElementById("ul");
    let li = document.createElement("li");
    li.innerHTML=inp.value;
    ul.appendChild(li);
    inp.value = "";
}