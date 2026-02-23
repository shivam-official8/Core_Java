import { useCallback, useEffect, useRef, useState } from 'react'


function App() {
  const [length, setLength] = useState(8);
  const [isNumber, setNumber] = useState(false);
  const [isCharcter, setCharacter] = useState(false);
  const [password, setPassword] = useState("");
  // ref hook

  const passwordRef = useRef(null);

  const passwordGenerator = useCallback(()=>{
    let pass = "";
    let str = "ABCDEGFHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    if(isNumber) str += "0123456789";
    if(isCharcter) str += "!@#$%^&*(){}_+=~";

    for(let i=1;i<=length;i++){
      let char = Math.floor((Math.random()*str.length));
      pass += str.charAt(char);
    }
    setPassword(pass);

  }, [length, isCharcter, isNumber, setPassword]);


 const copyPasswordToClipboard = useCallback(()=>{
  window.navigator.clipboard.writeText(password);
}, [password])

useEffect(()=>{
passwordGenerator()
}, [length, isNumber, isCharcter, passwordGenerator])

  return (
    <>
<div className="w-full max-w-md mx-auto my-8 rounded-lg bg-gray-800 px-4 py-5 shadow-md text-orange-500">
  
  <h1 className="mb-5 text-center text-2xl font-semibold text-white">
    Password Generator
  </h1>

  {/* Password Field */}
  <div className="mb-4 flex items-center overflow-hidden rounded-lg bg-gray-700">
    <input
      type="text"
      value={password}
      className="w-full bg-transparent px-3 py-2 text-white outline-none"
      placeholder="Password"
      readOnly
      ref={passwordRef}
    />
    <button
      onClick={copyPasswordToClipboard}
      className="shrink-0 bg-blue-600 px-4 py-2 text-white hover:bg-blue-700"
    >
      Copy
    </button>
  </div>

  {/* Controls */}
  <div className="flex flex-col gap-3 text-sm">

    {/* Length */}
    <div className="flex items-center gap-2">
      <input
        type="range"
        min={6}
        max={100}
        value={length}
        className="w-full cursor-pointer accent-orange-500"
        onChange={(e) => setLength(e.target.value)}
      />
      <span className="whitespace-nowrap">Length: {length}</span>
    </div>

    {/* Options */}
    <div className="flex gap-4">
      <label className="flex items-center gap-1">
        <input
          type="checkbox"
          checked={isNumber}
          onChange={() => setNumber(prev => !prev)}
        />
        Numbers
      </label>

      <label className="flex items-center gap-1">
        <input
          type="checkbox"
          checked={isCharcter}
          onChange={() => setCharacter(prev => !prev)}
        />
        Characters
      </label>
    </div>

  </div>
</div>
    </>
  )
}

export default App
