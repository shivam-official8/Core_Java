import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
function App() {
  const [task, setTask] = useState("")
  const [toDo, setToDo] = useState([]);

function handleBgColor(color){
  document.body.style.backgroundColor = color
}


function handleOnClick(e){
   e.preventDefault();
console.log("heelooo");
console.log("hiiieeiei");

console.log("yeeeeeyeyeyeyeyeyeyeyeeee");

console.log("I'm here!");



  if(task.length !=0){
    console.log("tttttttttttttttttttttTTTTTTTTTTTTTTTTTTTTT");
    
    setToDo([...toDo, task]);
  }
  else{
    alert("please enter something!")
  }
  console.log(task);
  
  console.log(toDo);
  setTask("");
  
}
function removeHandle(idx){
  console.log("im here !");
  
  const result = toDo.filter((_, i) => i !== idx);
  setToDo(result);
}
  return (
    <>
<h3>Total Tasks: {toDo.length}</h3>
    <form action="">
    <input type="text" name="" id="" value={task} onChange={(e)=>setTask(e.target.value)}  />
    <button type="submit" onClick={handleOnClick}>Add</button>
    </form>
<ul>
 { toDo.map((e, idx)=> {
      return (
        <li key={idx}>
          {e} 
          <button onClick={()=>removeHandle(idx)}>Remove</button>
        </li>
      );
    })}
</ul>

<div>
 <button onClick={()=>handleBgColor("blue")}>Blue</button> <button onClick={()=>handleBgColor("red")}>Red</button> <button onClick={()=>handleBgColor("green")}>Green</button> <button onClick={()=>handleBgColor("purple")}>Purple</button> <button onClick={()=>handleBgColor("orange")}>Orange</button>
</div>
  
    </>
  )

  

}

export default App
