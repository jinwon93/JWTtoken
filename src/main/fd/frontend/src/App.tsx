import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from  "./Components/Home";
import PrivateRoute from "./Auth/PrivateRoute";
import RestrictedRoute from "./Auth/RestrictedRoute";
import Login from "./Components/Login";
import SignUp from "./Components/SignUp";



function App() {
  // const [ data , setData] = useState(null);
  //
  // useEffect(() => {
  //   axios("/test/hellow").then((res) => {
  //     setData(res.data);
  //
  //   })
  // } ,  [])
  //
  // return <div>서버에서 받은 데이터 : {data}</div>



    return (
        <BrowserRouter>
            <Routes>
                <RestrictedRoute exact path="/login" component={Login}/>
                <PrivateRoute exact path="/" component={Home}/>

                <RestrictedRoute exact  path="/register" component={SignUp}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
