import axios  ,{AxiosError , AxiosResponse} from "axios";



type ServerError = {errorMessage  :string } ;
type  LoginFailType = { status : number , error : string};

// axios 에러캐치 추상화

interface  FetchAuthAction {

    method : string,
    url : string ,
    data? :{},
    header : {},
}


const FetchAuth = async (fetchData : FetchAuthAction) =>{

    const method = fetchData.method;
    const url  = fetchData.url;
    const data  = fetchData.data;
    const header  = fetchData.header;


    try {

        const response:AxiosResponse<any , any> | false =
            (method === 'get'  && (await  axios.get(url , header))) ||
            (method === 'post'  && (await  axios.post(url , data ,  header))) ||
            (method === 'put'  && (await  axios.put(url , data ,  header))) ||
            (method === 'delete'  && (await  axios.delete(url , header)));


        if (response && response.data.error) {
            console.log((response.data as  LoginFailType).error);
            alert("Wrong ID or Password");
            return null;
        }

        if (!response) {
            alert("false!");
            return null;
        }

        return response;
    }catch (err) {

        if (axios.isAxiosError(err)) {
            const serverError = err as AxiosError<ServerError>;
            if (serverError && serverError.response) {
                console.log(serverError.response.data);
                alert("failed!");
                return null;
            }
        }

        console.log(err);
        alert("failed!");
        return  null;
    }

}


export  default  FetchAuthAction;