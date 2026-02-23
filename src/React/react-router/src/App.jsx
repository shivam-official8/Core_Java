import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import { Router, Routes, BrowserRouter , Route} from 'react-router-dom'
import './App.css'
import Header from './components/Header'
import Home from './components/Home'
import Footer from './components/Footer'
import About from './components/About'
import Contact from './components/Contact'
import Layout from './Layout'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <Routes>
      <Route  element={<Layout/>}>
      <Route path='/' element={<Home/>}/>
      <Route path='/about' element={<About/>}/>
      <Route path='/contact' element={<Contact/>}/>
      </Route>
     
    </Routes>
    </>
  )
}

export default App
