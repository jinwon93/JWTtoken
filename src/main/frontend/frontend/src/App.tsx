import React  , {useState , useEffect } from 'react';
import axios from "axios";

function App() {


  const [ data , setData] = useState(null);

  useEffect(() => {
    axios("/api/test").then((res) => {
      setData(res.data);
    })
  } ,  [])

  return <div>서버에서 받은 데이터 : {data}</div>
}

export default App;
