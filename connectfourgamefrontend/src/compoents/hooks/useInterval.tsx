import{useEffect, useRef} from 'react';

export function useInterval(callback: any, delay: number){
    const savedCallBack: any = useRef();
    //Remembers Latest Callback
    useEffect(() =>{
        savedCallBack.current = callback;
    }, [callback]);

    //set up interval 
    useEffect(() => {
        function tick() {
            savedCallBack.current();
        }
        if ( delay !== null){
            const id = setInterval(tick, delay);
            return () => {
                clearInterval(id);
            };
        }
    }, [callback, delay]);
}