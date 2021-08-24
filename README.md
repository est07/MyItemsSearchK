# My Items Search

Esta aplicación fue realizada con el objetivo de implementar diferentes componentes como ViewModel, LiveData, y inyectar dependencias con Koin ademas de realizar la navegación entre pantallas, con el paquete de AndroidX.


## Using :

[Retrofit](http://square.github.io/retrofit/)

[Moshi](https://github.com/square/moshi)

[RxAndroid](https://github.com/ReactiveX/rxandroid)

[Picasso](https://github.com/square/picasso)

[AndroidX](https://developer.android.com/jetpack/androidx)

[Koin](https://github.com/InsertKoinIO/koin)

#Project structure 

El proyecto fue realizado con el patrón de diseño de clean architecture por lo cual esta compuesto por tres package los cuales son data, domain,  y presentation.

En el package de data se encuentran los packages de mapper se el cual contiene los componentes que nos permiten comunicar la capa de data con la de presentation siguiendo el patrón de  clean architecture, y en el package service se encuentran los componentes que nos permiten realizar consultas al API de api.mercadolibre.com.

En el package de domain se encuentran los componentes que nos permiten la comunicación de esta capa con la de data y presentation, ademas de los datos que se envían entre estas, también si existe una lógica de negoció se manejaría en esta capa.

En el package de presentation se encuentran todos los componentes que son utilizados para mostrar las vistas.

# En la imagen mostrada a continuación se puede observar el funcionamiento del app.

 Búsqueda simple
![Alt text](/Images/search_navigation.gif)
 Error en la búsqueda
![Alt text](/Images/search_error.gif)
 Error  de conexión
![Alt text](/Images/search_failed.gif)

# How it looks

A continuación se puede observar los Screenschots de cada una de las ventanas del app.

![Alt text](/Images/Screenshot_1629470234.png){: width=200px}
![Alt text](/Images/Screenshot_1629763000.png){: width=200px}
![Alt text](/Images/Screenshot_1629763011.png){: width=200px}
![Alt text](/Images/Screenshot_1629762984.png){: width=200px}
![Alt text](/Images/Screenshot_1629493673.png){: width=200px}
![Alt text](/Images/Screenshot_1629493662.png){: width=200px}

# Resources:

https://www.raywenderlich.com/5365-jetpack-navigation-controller
https://www.raywenderlich.com/5046-android-architecture-components-viewmodel
https://www.raywenderlich.com/4980-android-architecture-components-livedata
https://www.raywenderlich.com/8984-mvvm-on-android
https://www.raywenderlich.com/5730-dependency-injection-with-koin
https://developer.android.com/jetpack/androidx/releases/navigation


