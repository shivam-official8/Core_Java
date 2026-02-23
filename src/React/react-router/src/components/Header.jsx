import { useState } from "react";
import { Link, NavLink } from "react-router-dom";

export default function Header() {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <header className="sticky top-0 z-50 shadow">
      <nav className="border-gray-200 bg-white px-4 py-2.5 lg:px-6">
        <div className="mx-auto flex max-w-screen-xl flex-wrap items-center justify-between">
          
          {/* Logo */}
          <Link to="/" className="flex items-center">
            <img
              src="https://alexharkness.com/wp-content/uploads/2020/06/logo-2.png"
              className="mr-3 h-12"
              alt="Logo"
            />
          </Link>

          {/* Right buttons */}
          <div className="flex items-center lg:order-2">
            <Link
              to="/login"
              className="mr-2 rounded-lg px-4 py-2 text-sm font-medium text-gray-800 hover:bg-gray-50"
            >
              Log in
            </Link>
            <Link
              to="/signup"
              className="mr-2 rounded-lg bg-orange-700 px-4 py-2 text-sm font-medium text-white hover:bg-orange-800"
            >
              Get started
            </Link>

            {/* Mobile menu button */}
            <button
              onClick={() => setIsOpen(!isOpen)}
              className="ml-2 inline-flex items-center rounded-lg p-2 text-gray-500 hover:bg-gray-100 lg:hidden"
            >
              ☰
            </button>
          </div>

          {/* Navigation links */}
          <div
            className={`w-full items-center justify-between lg:order-1 lg:flex lg:w-auto ${
              isOpen ? "flex" : "hidden"
            }`}
          >
            <ul className="mt-4 flex flex-col font-medium lg:mt-0 lg:flex-row lg:space-x-8">
              <li>
                <NavLink
                  to="/"
                  className={({ isActive }) =>
                    `block py-2 pl-3 pr-4 duration-200 ${
                      isActive ? "text-orange-700" : "text-gray-700"
                    } hover:text-orange-700 lg:p-0`
                  }
                  onClick={() => setIsOpen(false)}
                >
                  Home
                </NavLink>
              </li>

              <li>
                <NavLink
                  to="/about"
                  className={({ isActive }) =>
                    `block py-2 pl-3 pr-4 duration-200 ${
                      isActive ? "text-orange-700" : "text-gray-700"
                    } hover:text-orange-700 lg:p-0`
                  }
                  onClick={() => setIsOpen(false)}
                >
                  About
                </NavLink>
              </li>


               <li>
                <NavLink
                  to="/contact"
                  className={({ isActive }) =>
                    `block py-2 pl-3 pr-4 duration-200 ${
                      isActive ? "text-orange-700" : "text-gray-700"
                    } hover:text-orange-700 lg:p-0`
                  }
                  onClick={() => setIsOpen(false)}
                >
                  Contact
                </NavLink>
              </li>
            </ul>
          </div>

        </div>
      </nav>
    </header>
  );
}