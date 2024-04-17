import SignIn from './components/SignIn'
import GetTicket from './components/GetTicket'
import CheckTicket from './components/CheckTicket'
import { RouterProvider, createBrowserRouter } from 'react-router-dom'

const router = createBrowserRouter([
  {
    path: '/',
    element: <SignIn />
  },
  {
    path: '/get/:accessToken',
    element: <GetTicket />
  },
  {
    path: '/check/:accessToken',
    element: <CheckTicket />
  },
]);

function App() {

  return (
    <RouterProvider router={router} />
  )
}

export default App
