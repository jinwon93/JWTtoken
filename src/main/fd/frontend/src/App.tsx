import React  , {useState , useEffect } from 'react';
import axios from "axios";
import {BrowserRouter , Router }  from "react-router-dom";
import Home from  "./Components/Home";
// import PrivateRoute from "./Auth/PrivateRoute";

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
          <Home />
          {/*<PrivateRoute exact path="/" component={Home} />*/}
      </BrowserRouter>
  )
}

export default App;
