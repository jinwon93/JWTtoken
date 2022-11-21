import React, { useContext } from 'react';
import {Routes , Route , Navigate} from "react-router-dom";
import AuthContext from "./store/AuthContext";




function App() {

    const authCtx = useContext(AuthContext);
  // const [ data , setData] = useState(null);
  //
  // useEffect(() => {
  //   axios("/test/hellow").then((res) => {
  //     setData(res.data);
  //
  //   })
  // } ,  [])`
  //
  // return <div>서버에서 받은 데이터 : {data}</div>



    return (
        <div>dddd</div>
    );
}

export default App;
