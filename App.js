import React, { useEffect } from 'react';
import SplashScreen from 'react-native-splash-screen';
import Pagina from './src';

export default function App() {
  useEffect(() => {
    SplashScreen.hide();
  }, []);

  return (
   <Pagina/>
  );
}