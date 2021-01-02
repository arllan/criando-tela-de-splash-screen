### Configurando Tela de splash screen.

Para o criar a tela de splash screen vamos utilizar a lib splash-screen e podemos ver mais detalhes em: [Documentação da lib react-native-splash-screen](https://github.com/crazycodeboy/react-native-splash-screen). Podemos ver outra referência em [Mini tutorial](https://medium.com/@willjcpower/configurando-a-splash-screen-no-react-native-cli-android-630e4255da22).

1- Para criar  tela de splash screen vamos precisar instalar a lib 
```
npm install react-native-splash-screen
```
2- Agora precisamos configurar a lib no projeto feito em react cli com o comando:
```
react-native link react-native-splash-screen
```
3- Agora precisamos adicionar o seguinte trecho de código no arquivo ***android\app\src\main\java\com\splash\MainActivity.java***

```java
import android.os.Bundle; // Este Aqui e vamos adicionar
import com.facebook.react.ReactActivity;//Este já esta no arquivo não modificar
import org.devio.rn.splashscreen.SplashScreen; // Este Aqui e vamos adicionar
```
4- Agora precisamos adicionar o trecho de código dentro do metodo. ***public  class  MainActivity  extends  ReactActivity***
```java
// Trecho que vamos precisar adicionar ele dentro do metodo abaixo
@Override
protected  void  onCreate(Bundle  savedInstanceState) {
	SplashScreen.show(this, R.style.SplashScreenTheme);
	super.onCreate(savedInstanceState);
}
```

4.1 -  Como deve ficar o arquivo.

```java
package com.splash;

import android.os.Bundle; // Este Aqui
import com.facebook.react.ReactActivity;//Este já esta no arquivo
import org.devio.rn.splashscreen.SplashScreen; // Este Aqui

public  class  MainActivity  extends  ReactActivity {

/**

* Returns the name of the main component registered from JavaScript. This is used to schedule

* rendering of the component.

*/

	@Override
	protected  void  onCreate(Bundle  savedInstanceState) {
		SplashScreen.show(this, R.style.SplashScreenTheme);
		super.onCreate(savedInstanceState);
	}

	@Override
	protected  String  getMainComponentName() {
		return  "splash";
	}
}
```
5 - Agora vamos começar a fazer as modificações nos arquivos ***.js*** Primeiro precisamos entender que configuramos e agora precisamos entender que a tela de ***splash screen*** vai ser carregada na tela e precisamos fazer o apôs a essa tela e para isso precisamos configurar.

```javascript
import  React, { useEffect } from  'react';
import  SplashScreen  from  'react-native-splash-screen';
import  Pagina  from  './src'; //  pagina que ele vai ser direcionado apos o carregamento da tela de splash screen

export  default  function  App() {
	useEffect(() => { // carrega quando e iniciado o carregamento da pagina
		SplashScreen.hide(); // esconde a tela de splash screen 
	}, []);

	return (
	<Pagina/> // Pagina que vai carregar e mostrar o seu contéudo apôs a tela de splah screen
	);
}
``` 
6- Agora precisamos criar o arquivo ***launch_screen.xml*** no diretorio ***android/app/src/main/res/criar_pasta_chamada_layout***. Esse arquivo e para configurar as propriedades da tela de splash screen.

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android" android:orientation="vertical"  android:layout_width="match_parent"
android:layout_height="match_parent">
<ImageView  android:layout_width="match_parent"  android:layout_height="match_parent"  android:src="@mipmap/launch_screen"  android:scaleType="centerCrop"/>
</RelativeLayout>
```
Esse trecho informa o nome da pasta ***@mipmap*** e informa o nome do arquivo ***launch_screen*** e o arquivo tem que ter o formato ***.png***
> android:src="@mipmap/launch_screen"


7- Agora precisamos gerar as imagens nos formatos certos que podemos utilizar algumas ferramentas e para isso vamos utilizar o [site da apetools](https://apetools.webprofusion.com/#/tools/imagegorilla)  

7.1 - Com a arte do app pronta vamos exporta para o site em alta resolusão ***recomendado 1920px por 1080px*** 

7.2 - Agora precisamos selecionar o botão *** Step 2 - Select Your Splashscreen*** e selecionar a plataforma que neste caso vamos utilizar o ***android***

7.3 - Agora vamos gerar as imagens clicando no botão  ***Download Zip*** e vai baixar a pasta. Agora vamos descompactar os arquivos e selecionar apenas os arquivos:
*  drawable-hdpi 
* drawable-mdpi
* drawable-xhdpi
* drawable-xxhdpi
* drawable-xxxhdpi

***IMPORTANTE:*** Todos os arquivos de imagem deve renomear para launch_screen.png e agora precisamos colocar cada formato de imagem dentro das pastas respectivas. O diretorio da pasta onde fica as imagens do projeto. ***android\app\src\main\res*** e agora vamos colocar a imagem em cada pasta.

*  ***launch_screen.png*** em formato ***hdpi*** -> na pasta projeto***mipmap-hdpi***

*  ***launch_screen.png*** em formato ***mipmap-mdpi*** -> na pasta do projeto ***mipmap-mdpi***

* ***launch_screen.png*** em formato ***mipmap-xhdpi*** -> na pasta projeto***mipmap-xhdpi***

* ***launch_screen.png*** em formato ***mipmap-xxhdpi*** -> na pasta projeto***mipmap-xxhdpi***

* ***launch_screen.png*** em formato ***mipmap-xxxhdpi*** -> na pasta projeto***mipmap-xxxhdpi***

8- Agora vamos criar o arquivo ***colors.xml*** na pasta ***app/src/main/res/values/colors.xml***.
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
	<color  name="background">#396fa9</color><!--cor de fundo-->
	<color  name="primary_dark">#396fa9</color><!--cor de fundo-->
	<color  name="status_bar_color">#396fa9</color><!--cor de fundo da navbar-->
</resources>
```

9- Agora vamos para o diretorio ***android/app/src/main/res/values/styles.xml***  e adicionar o seguinte trecho de código.
```xml
<resources>
<!-- Base application theme. -->
	<style  name="AppTheme"  parent="Theme.AppCompat.Light.NoActionBar">
	<!-- Customize your theme here. -->
	<item  name="android:textColor">#000000</item>
	</style>
	
	<!--Adicionar esse trecho de código-->
	<style  name="SplashScreenTheme"  parent="SplashScreen_SplashTheme">
	<item  name="colorPrimaryDark">@color/status_bar_color</item>
	</style>
	<!--Adicionar esse trecho de código-->
</resources>
```

10- Agora e só dá o build na aplicação ***npx react-native run-android***
