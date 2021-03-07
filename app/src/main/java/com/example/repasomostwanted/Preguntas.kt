package com.example.repasomostwanted

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.*
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_preguntas.*
import kotlin.random.Random


class Preguntas : AppCompatActivity() {

    /*//datos------------------------------------------------------------------------------------------------------------------------
    //xxxxxCodigoxxxxx-xxxxxxMuertoxxxxx
    var ya_esta_ese_random=true
    var randombtn=false //boton random
    var random=1 //random de siguiente
    var s2 = 0//para las solo malas!
    var haymalas=false //para saber si tocaste el boton de rehacer las malas
    var armalas=arrayListOf<Int>()
    var primera_impresion=true
//---xxxxxxxxxxxxx-xxxxxxxxxxxxxxxxx-------------------------------------------------------------------------------*/
    //var esta_foto=0
    // var apunta_hacia_la_izquierda=false
    var randomabc = 1//random de abc...
    var s1 = 1 //selector para funcion comun de uno en uno todas
    var tamaño = 20f
    var arbuenas = arrayListOf<Int>()
    var tam = false //es para la impresion de tamaños exagradoa de cara<cteres
    var s = 1
    var botonAtras = true
    var tema_seleccionado: String? = null

    /////////////inicio las variables a usar ocn valores random, tratando de que sean livianos////
    var array_imagenes = arrayOf(R.drawable.imagen39)
    var respuesta_de_las_imagenes =
        arrayListOf(
            0,
            0,
            0
        )//el cero es para que no se pase, porque le resto 1 para que aparezca la primera, entopnces tengo que sumarle uno de mas para que le reste uno y aparezca la ultima, entonces pongo el cero!!
    var arreglo_de_preguntas = R.array.introp //preguntas
    var arreglo_de_respuestas = R.array.intror //respuestas

        ///////////////////////////////////////////////////////////////////////
        var arteAsciLPM = arrayOf(R.drawable.arte1tabla404, R.drawable.arte2tabla1017)
        var verRespuestaAnterior = false
        var miraQueToqueVerPreguntaNoVuelvasAtrasComoSiFueseUnaPreguntaPorqueYaLaRespondiRecien = false


    var toastSuperpuesto:Toast?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preguntas)
        //visible(sig)
        //visible(btn_verQue)
        s1 = 1
        arbuenas.clear()
        th1.text = """Hola! Soy Ezequiel, este es el primer app dentro de todo seria que hice, la idea a futuro es crear apps similares y cobrarlas bien baratas.
· Me sirve MUCHISIMO que me avisen cuando el app ande mal o falle, tambien si tienen ideas para que agregue. Si tocan el icono de "Problema" que está arrriba a la izquierda se abre mi WhatsApp sin que tengan que agendarme. Es tocar el icono, escribir, enviar y listo.
· Para aumentar o reducir el tamaño de la letra usen las lupitas
· Para ir a otras preguntas usen las flechas arriba y abajo
· La estrella es para estadisticas, va a estar disponible mas adelante
· Ahi abajo a la izquierda hay un botón que dice "Reglamento de Exámenes". Si lo tocan los manda a una carpeta en drive donde esta colgado el reglamento, lo pongo asi porque es importantisimo pero en la página de FMed no aparece.

COMO CONTESTAR LAS PREGUNTAS
1) Toquen la respuesta que les parezca correcta, si quieren tocar la F o la G toquen F/G, este boton abre las dos opciones y ahi elijen.
2) Cuando marquen alguna respuesta, este bien o mal contestada aparece la respuesta correcta.
3) Si quieren volver a ver la pregunta toquen el botón "Ver Pregunta" 
4) Luego tocan siguiente y van a la que viene.


Espero que disfrutes del app y que te ayude un montón 

Version 1.04 😎
Mejoras y parcheadas
• Redimensionamiento de las imagenes (para que se puedan mostrar sin colgarse en mas dispositivos)
• Enlace a compilado de choices agregado a la pantalla principal
• Letra de respuesta pintada de verde (para evitar confusiones)
- Cualquier idea que tengas si queres comentamela y las voy implementando

Saludos!
"""


        tema_seleccionado = intent.getStringExtra("tema_seleccionado")

        //Golden When
        when {


            tema_seleccionado == "intro" -> {
                //array_imagenes = arrayOf(
                //) sin imagenes!

                /* respuesta_de_las_imagenes = arrayListOf(
                     0,
                     //Sin imagenes!!
                     0
                 )*///el cero es para que no se pase, porque le resto 1 para que aparezca la primera, entopnces tengo que sumarle uno de mas para que le reste uno y aparezca la ultima, entonces pongo el cero!!
                arreglo_de_preguntas = R.array.introp //preguntas
                arreglo_de_respuestas = R.array.intror //respuestas

            }



                       tema_seleccionado == "celula" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen5,
                               R.drawable.imagen6,
                               R.drawable.imagen7,
                               R.drawable.imagen8,
                               R.drawable.imagen9,
                               R.drawable.imagen10,
                               R.drawable.imagen11,
                               R.drawable.imagen12,
                               R.drawable.imagen13
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               8, 11, 12, 14, 21, 25, 31, 34, 37, 0

                           )//el cero es para que no se pase, porque le resto 1 para que aparezca la primera, entopnces tengo que sumarle uno de mas para que le reste uno y aparezca la ultima, entonces pongo el cero!!
                           arreglo_de_preguntas = R.array.celulap //preguntas
                           arreglo_de_respuestas = R.array.celular //respuestas

                       }

                       tema_seleccionado == "infrep" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen14,
                               R.drawable.imagen15,
                               R.drawable.imagen16,
                               R.drawable.imagen17,
                               R.drawable.imagen18,
                               R.drawable.imagen19,
                               R.drawable.imagen20

                           )
                           respuesta_de_las_imagenes = arrayListOf(0, 2, 25, 26, 33, 40, 42, 46, 0)
                           arreglo_de_preguntas = R.array.infrepp //preguntas
                           arreglo_de_respuestas = R.array.infrepr //respuestas

                       }
                       tema_seleccionado == "hemo" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen21,
                               R.drawable.imagen22,
                               R.drawable.imagen23,
                               R.drawable.imagen24,
                               R.drawable.imagen25,
                               R.drawable.imagen26,
                               R.drawable.imagen27,
                               R.drawable.imagen28,
                               R.drawable.imagen29
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               5, 7, 9, 22, 25, 26, 28, 32, 33, 0
                           )
                           arreglo_de_preguntas = R.array.hemop //preguntas
                           arreglo_de_respuestas = R.array.hemor //respuestas
                       }


                       tema_seleccionado == "genetica" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen30,
                               R.drawable.imagen31,
                               R.drawable.imagen32,
                               R.drawable.imagen33,
                               R.drawable.imagen34,
                               R.drawable.imagen35,
                               R.drawable.imagen36,
                               R.drawable.imagen37,
                               R.drawable.imagen38
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               11, 14, 18, 22, 24, 25, 26, 28, 37, 0
                           )
                           arreglo_de_preguntas = R.array.geneticap //preguntas
                           arreglo_de_respuestas = R.array.geneticar //respuestas
                       }


                       tema_seleccionado == "inmuno" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen39,
                               R.drawable.imagen40,
                               R.drawable.imagen41,
                               R.drawable.imagen42,
                               R.drawable.imagen43,
                               R.drawable.imagen44,
                               R.drawable.imagen45
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               19, 21, 23, 25, 31, 56, 58, 0
                           )
                           arreglo_de_preguntas = R.array.inmunop //preguntas
                           arreglo_de_respuestas = R.array.inmunor //respuestas
                       }


                       tema_seleccionado == "neo" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen46,
                               R.drawable.imagen47,
                               R.drawable.imagen48,
                               R.drawable.imagen49,
                               R.drawable.imagen50,
                               R.drawable.imagen51,
                               R.drawable.imagen52,
                               R.drawable.imagen53,
                               R.drawable.imagen54

                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               4, 6, 8, 9, 11, 18, 51, 53, 57, 0
                           )
                           arreglo_de_preguntas = R.array.neop //preguntas
                           arreglo_de_respuestas = R.array.neor //respuestas
                       }


                       tema_seleccionado == "infecciosas" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen55,
                               R.drawable.imagen56,
                               R.drawable.imagen57,
                               R.drawable.imagen58,
                               R.drawable.imagen59,
                               R.drawable.imagen60,
                               R.drawable.imagen61,
                               R.drawable.imagen62,
                               R.drawable.imagen63,
                               R.drawable.imagen64,
                               R.drawable.imagen65,
                               R.drawable.imagen66,
                               R.drawable.imagen67

                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               4, 14, 16, 19, 33, 36, 44, 48, 49, 50, 51, 54, 60, 0
                           )
                           arreglo_de_preguntas = R.array.infecciosasp //preguntas
                           arreglo_de_respuestas = R.array.infecciosasr //respuestas
                       }


                       tema_seleccionado == "ambnut" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen68,
                               R.drawable.imagen69,
                               R.drawable.imagen70
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               25, 27, 39, 0
                           )
                           arreglo_de_preguntas = R.array.ambnutp //preguntas
                           arreglo_de_respuestas = R.array.ambnutr //respuestas
                       }


                       tema_seleccionado == "lacinfancia" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen71,
                               R.drawable.imagen72,
                               R.drawable.imagen73,
                               R.drawable.imagen74,
                               R.drawable.imagen75,
                               R.drawable.imagen76

                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,
                               1, 3, 23, 31, 44, 46,
                               0
                           )
                           arreglo_de_preguntas = R.array.lacinfanciap //preguntas
                           arreglo_de_respuestas = R.array.lacinfanciar //respuestas
                       }


                       tema_seleccionado == "vasos" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen77,
                               R.drawable.imagen78,
                               R.drawable.imagen79,
                               R.drawable.imagen80,
                               R.drawable.imagen81,
                               R.drawable.imagen82,
                               R.drawable.imagen83,
                               R.drawable.imagen84
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               9, 20, 22, 26, 28, 39, 47, 49, 0
                           )
                           arreglo_de_preguntas = R.array.vasosp //preguntas
                           arreglo_de_respuestas = R.array.vasosr //respuestas
                       }


                       tema_seleccionado == "cora" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen85,
                               R.drawable.imagen86,
                               R.drawable.imagen87,
                               R.drawable.imagen88,
                               R.drawable.imagen89,
                               R.drawable.imagen90,
                               R.drawable.imagen91,
                               R.drawable.imagen92,
                               R.drawable.imagen93,
                               R.drawable.imagen94,
                               R.drawable.imagen95,
                               R.drawable.imagen96
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               10, 15, 19, 22, 27, 32, 33, 35, 39, 41, 56, 58, 0
                           )
                           arreglo_de_preguntas = R.array.corap //preguntas
                           arreglo_de_respuestas = R.array.corar //respuestas
                       }


                       tema_seleccionado == "leuco" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen97,
                               R.drawable.imagen98,
                               R.drawable.imagen99,
                               R.drawable.imagen100,
                               R.drawable.imagen101,
                               R.drawable.imagen102,
                               R.drawable.imagen103,
                               R.drawable.imagen104,
                               R.drawable.imagen105,
                               R.drawable.imagen106,
                               R.drawable.imagen107,
                               R.drawable.imagen108,
                               R.drawable.imagen109,
                               R.drawable.imagen110,
                               R.drawable.imagen111
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               3, 9, 16, 20, 26, 28, 29, 32, 41, 45, 50, 53, 55, 57, 0
                           )
                           arreglo_de_preguntas = R.array.leucop //preguntas
                           arreglo_de_respuestas = R.array.leucor //respuestas
                       }


                       tema_seleccionado == "eritro" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen112,
                               R.drawable.imagen113,
                               R.drawable.imagen114,
                               R.drawable.imagen115,
                               R.drawable.imagen116
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               6, 12, 28, 30, 46, 0
                           )
                           arreglo_de_preguntas = R.array.eritrop //preguntas
                           arreglo_de_respuestas = R.array.eritror //respuestas
                       }


                       tema_seleccionado == "pulmon" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen117,
                               R.drawable.imagen118,
                               R.drawable.imagen119,
                               R.drawable.imagen120,
                               R.drawable.imagen121,
                               R.drawable.imagen122,
                               R.drawable.imagen123,
                               R.drawable.imagen124,
                               R.drawable.imagen125,
                               R.drawable.imagen126,
                               R.drawable.imagen127,
                               R.drawable.imagen128,
                               R.drawable.imagen129,
                               R.drawable.imagen130,
                               R.drawable.imagen131,
                               R.drawable.imagen132,
                               R.drawable.imagen133
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               3, 11, 24, 30, 32, 38, 39, 41, 48, 57, 59, 61, 63, 64, 66, 68, 70, 0
                           )
                           arreglo_de_preguntas = R.array.pulmonp //preguntas
                           arreglo_de_respuestas = R.array.pulmonr //respuestas
                       }


                       tema_seleccionado == "cabcue" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen134,
                               R.drawable.imagen135,
                               R.drawable.imagen136,
                               R.drawable.imagen137
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               8, 10, 22, 32, 0
                           )
                           arreglo_de_preguntas = R.array.cabcuep //preguntas
                           arreglo_de_respuestas = R.array.cabcuer //respuestas
                       }


                       tema_seleccionado == "diges" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen138,
                               R.drawable.imagen139,
                               R.drawable.imagen140,
                               R.drawable.imagen141,
                               R.drawable.imagen142,
                               R.drawable.imagen143,
                               R.drawable.imagen144,
                               R.drawable.imagen145,
                               R.drawable.imagen146,
                               R.drawable.imagen147,
                               R.drawable.imagen148,
                               R.drawable.imagen149,
                               R.drawable.imagen150
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               14, 16, 22, 30, 48, 53, 55, 56, 62, 63, 64, 66, 67, 0
                           )
                           arreglo_de_preguntas = R.array.digesp //preguntas
                           arreglo_de_respuestas = R.array.digesr //respuestas
                       }


                       tema_seleccionado == "higado" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen151,
                               R.drawable.imagen152,
                               R.drawable.imagen153,
                               R.drawable.imagen154,
                               R.drawable.imagen155,
                               R.drawable.imagen156,
                               R.drawable.imagen157,
                               R.drawable.imagen158,
                               R.drawable.imagen159,
                               R.drawable.imagen160
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               4, 9, 27, 29, 43, 47, 49, 54, 57, 60, 0
                           )
                           arreglo_de_preguntas = R.array.higadop //preguntas
                           arreglo_de_respuestas = R.array.higador //respuestas
                       }


                       tema_seleccionado == "pancreas" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen161,
                               R.drawable.imagen162,
                               R.drawable.imagen163,
                               R.drawable.imagen164
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               1, 6, 14, 15, 0
                           )
                           arreglo_de_preguntas = R.array.pancreasp //preguntas
                           arreglo_de_respuestas = R.array.pancreasr //respuestas
                       }


                       tema_seleccionado == "riñon" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen165,
                               R.drawable.imagen166,
                               R.drawable.imagen167,
                               R.drawable.imagen168,
                               R.drawable.imagen169,
                               R.drawable.imagen170,
                               R.drawable.imagen171,
                               R.drawable.imagen172,
                               R.drawable.imagen173,
                               R.drawable.imagen174
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               7, 8, 13, 15, 26, 40, 44, 48, 53, 57, 0
                           )
                           arreglo_de_preguntas = R.array.riñonp //preguntas
                           arreglo_de_respuestas = R.array.riñonr //respuestas
                       }


                       tema_seleccionado == "masculino" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen175,
                               R.drawable.imagen176,
                               R.drawable.imagen177,
                               R.drawable.imagen178,
                               R.drawable.imagen179,
                               R.drawable.imagen180,
                               R.drawable.imagen181,
                               R.drawable.imagen182,
                               R.drawable.imagen183
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               7, 8, 9, 16, 21, 24, 25, 0
                           )
                           arreglo_de_preguntas = R.array.masculinop //preguntas
                           arreglo_de_respuestas = R.array.masculinor //respuestas
                       }


                       tema_seleccionado == "femenino" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen184,
                               R.drawable.imagen185,
                               R.drawable.imagen186,
                               R.drawable.imagen187,
                               R.drawable.imagen188,
                               R.drawable.imagen189,
                               R.drawable.imagen190,
                               R.drawable.imagen191,
                               R.drawable.imagen192,
                               R.drawable.imagen193,
                               R.drawable.imagen194,
                               R.drawable.imagen195
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               7, 10, 13, 17, 24, 31, 36, 38, 40, 41, 50, 52, 0
                           )
                           arreglo_de_preguntas = R.array.femeninop //preguntas
                           arreglo_de_respuestas = R.array.femeninor //respuestas
                       }


                       tema_seleccionado == "mama" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen196,
                               R.drawable.imagen197,
                               R.drawable.imagen198,
                               R.drawable.imagen199,
                               R.drawable.imagen200,
                               R.drawable.imagen201,
                               R.drawable.imagen202,
                               R.drawable.imagen203,
                               R.drawable.imagen204,
                               R.drawable.imagen205
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               1, 10, 12, 14, 15, 16, 17, 18, 26, 29, 0
                           )
                           arreglo_de_preguntas = R.array.mamap //preguntas
                           arreglo_de_respuestas = R.array.mamar //respuestas
                       }


                       tema_seleccionado == "endocrino" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen206,
                               R.drawable.imagen207,
                               R.drawable.imagen208,
                               R.drawable.imagen209,
                               R.drawable.imagen210,
                               R.drawable.imagen211,
                               R.drawable.imagen212
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               13, 17, 25, 26, 44, 49, 54, 0
                           )
                           arreglo_de_preguntas = R.array.endocrinop //preguntas
                           arreglo_de_respuestas = R.array.endocrinor //respuestas
                       }


                       tema_seleccionado == "piel" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen213,
                               R.drawable.imagen214,
                               R.drawable.imagen215,
                               R.drawable.imagen216,
                               R.drawable.imagen217,
                               R.drawable.imagen218,
                               R.drawable.imagen219
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               4, 9, 10, 15, 17, 27, 36, 0
                           )
                           arreglo_de_preguntas = R.array.pielp //preguntas
                           arreglo_de_respuestas = R.array.pielr //respuestas
                       }


                       tema_seleccionado == "huesos" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen213,
                               R.drawable.imagen214,
                               R.drawable.imagen215,
                               R.drawable.imagen216,
                               R.drawable.imagen217,
                               R.drawable.imagen218,
                               R.drawable.imagen219

                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               11, 20, 22, 23, 24, 25, 32, 33, 42, 43, 45, 53, 0
                           )
                           arreglo_de_preguntas = R.array.huesosp //preguntas
                           arreglo_de_respuestas = R.array.huesosr //respuestas
                       }


                       tema_seleccionado == "nervios" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen232,
                               R.drawable.imagen233
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               18, 19, 0
                           )
                           arreglo_de_preguntas = R.array.nerviosp //preguntas
                           arreglo_de_respuestas = R.array.nerviosr //respuestas
                       }


                       tema_seleccionado == "snc" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen234,
                               R.drawable.imagen235,
                               R.drawable.imagen236,
                               R.drawable.imagen237,
                               R.drawable.imagen238,
                               R.drawable.imagen239,
                               R.drawable.imagen240,
                               R.drawable.imagen241,
                               R.drawable.imagen242,
                               R.drawable.imagen243,
                               R.drawable.imagen244
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               8, 9, 12, 20, 26, 33, 47, 53, 55, 59, 73, 0
                           )
                           arreglo_de_preguntas = R.array.sncp //preguntas
                           arreglo_de_respuestas = R.array.sncr //respuestas
                       }


                       tema_seleccionado == "ojo" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen245,
                               R.drawable.imagen246,
                               R.drawable.imagen247,
                               R.drawable.imagen248
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               8, 11, 13, 23, 0
                           )
                           arreglo_de_preguntas = R.array.ojop //preguntas
                           arreglo_de_respuestas = R.array.ojor //respuestas
                       }


                       tema_seleccionado == "final" -> {
                           array_imagenes = arrayOf(
                               R.drawable.imagen249,
                               R.drawable.imagen250,
                               R.drawable.imagen251,
                               R.drawable.imagen252,
                               R.drawable.imagen253,
                               R.drawable.imagen254,
                               R.drawable.imagen255,
                               R.drawable.imagen256,
                               R.drawable.imagen257,
                               R.drawable.imagen258,
                               R.drawable.imagen259,
                               R.drawable.imagen260,
                               R.drawable.imagen261,
                               R.drawable.imagen262,
                               R.drawable.imagen263,
                               R.drawable.imagen264,
                               R.drawable.imagen265
                           )
                           respuesta_de_las_imagenes = arrayListOf(
                               0,

                               3, 10, 15, 26, 29, 31, 34, 39, 44, 46, 51, 60, 62, 64, 66, 70, 73, 0
                           )
                           arreglo_de_preguntas = R.array.finalp //preguntas
                           arreglo_de_respuestas = R.array.finalr //respuestas
                       }


                       //modelo
                       /* tema_seleccionado==""->{
                            array_imagenes=arrayOf(

                            )//sacar ultima coma!!
                            respuesta_de_las_imagenes=arrayListOf(0,,0)
                            arreglo_de_preguntas=R.array.p //preguntas
                            arreglo_de_respuestas=R.array.r //respuestas

                        }*/


                   }






                   sig.text = "Empecemos"


                   siguiente()
                   abcdefg(A)
                   abcdefg(B)
                   abcdefg(C)
                   abcdefg(D)
                   abcdefg(E)
                   abcdefg(F)
                   abcdefg(G)

                   btn_verImagen.setOnClickListener {
                       invisible(A)
                       invisible(B)
                       invisible(C)
                       invisible(D)
                       invisible(E)
                       invisible(F)
                       invisible(G)
                       invisible(btn_verImagen)//se encarga boton atras de ir para atras
                       invisible(scrollView2)
                       invisible(sig)
                       invisible(btn_verQue)
                       visible(photo_view)

                       layo.setBackgroundColor(resources.getColor(R.color.negro))
                       if (tema_seleccionado == "lacinfancia" && s1 == 17) {

                           photo_view.setImageResource(arteAsciLPM!![0])
                       } else if (tema_seleccionado == "masculino" && s1 == 37) {

                           photo_view.setImageResource(arteAsciLPM!![1])

                       } else {
                           photo_view.setImageResource(array_imagenes!![s - 1])
                       } //se carga la 0 y despues las demas en orden}

           //-1 es para qu muestre la primera, sino el sig le suma uno y muestra la 1, en vez de la 0
                   }
                   btn_verQue.setOnClickListener {
                       verRespuestaAnterior()
                   }
               }


               override fun onBackPressed() {

                   if (photo_view.visibility == VISIBLE) {
                       visible(btn_verImagen)
                       invisible(photo_view)
                       visible(scrollView2)
                       //btn_verImagen.text="V e r     I m a g e n"

                       layo.setBackgroundResource(R.drawable.fondock) //Color(resources.getColor(R.color.negro))
                       var esNoEs = es_una_respuesta()


                       if (esNoEs == false) {
                           visible(A)
                           visible(B)
                           visible(C)
                           visible(D)
                           visible(E)
                           visible(F)
                       } else {
                           visible(sig)
                           visible(btn_verQue)
                       }
                       if (F.text == "F") {
                           visible(G)
                       }
                   } else {
                       super.onBackPressed()
                   }

               }
               fun abcdefg(id_del_boton: Button) {

                   id_del_boton.setOnClickListener {

                       if (id_del_boton != F || id_del_boton == F && G.visibility == VISIBLE) {

                           F.text = "F/G" //SE HACE INVISIBLE ABAJO!
                           F.textSize = 19F
                           F.setTextColor(resources.getColor(R.color.grisCulo))

                           val span=SpannableString(resources.getStringArray(arreglo_de_respuestas!!)[s1])
                           val green=ForegroundColorSpan(Color.GREEN)

                           if(resources.getStringArray(arreglo_de_respuestas!!)[s1][2].isUpperCase()) span.setSpan(green,2,3, Spanned.SPAN_INCLUSIVE_INCLUSIVE)

                           else if(resources.getStringArray(arreglo_de_respuestas!!)[s1][3].isUpperCase()) span.setSpan(green,3,4, Spanned.SPAN_INCLUSIVE_INCLUSIVE)

                           th1.text=span

                           randomabc = Random.nextInt(64)

                           var rtam = if (randomabc < 13) {
                               resources.getStringArray(R.array.rpmal)[randomabc].toString()
                           } else {
                               resources.getStringArray(R.array.rpmal)[13]
                           }

                           //if(haymalas==false) {
                           var opcion_elegida_en_mayus = id_del_boton.text.toString()

                           if ("(" == resources.getStringArray(arreglo_de_respuestas!!)[s1][3].toString()) {
                               toast("Todas son Correctas \uD83D\uDE0E")
                               arbuenas.add(s1)
                           } else if (opcion_elegida_en_mayus == resources.getStringArray(arreglo_de_respuestas!!)[s1][2].toString()
                               || opcion_elegida_en_mayus == resources.getStringArray(arreglo_de_respuestas!!)[s1][3].toString()
                           ) {
                               toast("Correcta 😎")
                               arbuenas.add(s1)//+++++++++++++++++++++++ACA PONER EL SHARED!!!!!!!+++++++++++++++++++++++++
                           } else {
                               toast(rtam)
                               //armalas.add(s1)

                           }
                           s1++

           //}


           //if /hay malas==false
                           /*    else {

                            var opcion_elegida_en_mayus = id_del_boton.text.toString()
                            th1.text = resources.getStringArray(arreglo_de_respuestas!!)[armalas[s2]]

                            if (opcion_elegida_en_mayus == resources.getStringArray(arreglo_de_respuestas!!)[armalas[s2]][2].toString()
                                || opcion_elegida_en_mayus == resources.getStringArray(arreglo_de_respuestas!!)[armalas[s2]][3].toString()
                            ) {
                                var Toastsi = Toast.makeText(this, "Correcta \uD83D\uDE0E", Toast.LENGTH_SHORT)
                                Toastsi.setGravity(Gravity.BOTTOM, 0, 90)
                                Toastsi.show()
                                armalas.removeAt(s2) //elimina de las malas a esta!
                                s2--
                            } else {
                                var Toastno = Toast.makeText(this, rtam, Toast.LENGTH_SHORT)
                                Toastno.setGravity(Gravity.BOTTOM, 0, 90)
                                Toastno.show()

                            }
                            s2++
                   //tv2.text=s2.toString()
                            if (armalas.count() == 0) {
                                haymalas = false
                                var Toastlisto = Toast.makeText(this, "Correcta \uD83D\uDE0E, no hay mas respuestas malas!", Toast.LENGTH_LONG)
                                Toastlisto.setGravity(Gravity.BOTTOM, 0, 90)
                                Toastlisto.show()
                                s2=0


                            }
                            else if (s2==armalas.count()){
                                   haymalas = false
                                   var Toastquedanmalas = Toast.makeText(this, "Incorrecta!", Toast.LENGTH_SHORT)
                                   Toastquedanmalas.setGravity(Gravity.BOTTOM, 0, 90)
                                   Toastquedanmalas.show()
                   s2=0
                            }


                        }*/

                           visible(sig)
                           visible(btn_verQue)

                           invisible(A)
                           invisible(B)
                           invisible(C)
                           invisible(D)
                           invisible(E)
                           invisible(F)
                           invisible(G)

                       } else {
                           visible(G)
                           F.textSize = 30F
                           F.text = "F"
                           F.setTextColor(resources.getColor(R.color.negro))

                       }

                       if (s1 >= resources.getStringArray(arreglo_de_preguntas)
                               .count()
                       ) //preguntas en inmuno:60. su count es 61. Si el s1 es 61 se pasa, entonces si da 61 en este caso (inmuno agaugaguantaa) no pinta nada y vuelve
                       {
                           sig.text = "Volver al menu"

                       }
                   }
               }

               fun siguiente() {
                   sig.setOnClickListener {
                       verRespuestaAnterior = false
                       if (sig.text == "Volver al menu") {

                           val intento = Intent(this, MainActivity::class.java)
                           startActivity(intento)
                           toast(
                               "Respondiste " + arbuenas.count()
                                   .toString() + " bien."
                           )
                       } else {

                           when {
                               tema_seleccionado == "lacinfancia" && s1 == 17 -> {

                                   btn_verImagen.text = "V e r     T a b l a";visible(btn_verImagen)

                               }
                               tema_seleccionado == "masculino" && s1 == 37 -> {

                                   btn_verImagen.text = "V e r     T a b l a";visible(btn_verImagen)

                               }

                               s1 == respuesta_de_las_imagenes[s - 1] -> {
                                   s--;btn_verImagen.text = "V e r     I m a g e n";visible(btn_verImagen)
                               }
                               s1 == respuesta_de_las_imagenes[s] -> {
                                   visible(btn_verImagen);btn_verImagen.text = "V e r     I m a g e n"
                               }
                               s1 == respuesta_de_las_imagenes[s + 1] -> {
                                   s++;btn_verImagen.text = "V e r     I m a g e n";visible(btn_verImagen)
                               }
                               else -> {
                                   invisible(btn_verImagen)
                               }
                           }
                           //tv2.text=s1.toString()
                           invisible(photo_view)
                           /* if (randombtn == true) {

                           while (ya_esta_ese_random==true){
                               random=Random.nextInt (1,61)
                               ya_esta_ese_random=false
                               for (x in armalas+arbuenas){
                                   if (x==random){ya_esta_ese_random=true}
                               }

                           }
                           ya_esta_ese_random=true
                           s1 = random //iguala s1 al numero randomizado y arranca funcion a hacer lo suyo
                       }

                       else {sig.text="siguiente"}*/

                           sig.text = "Siguiente"
                           btn_verQue.text = "ver pregunta"

                           //if (haymalas == false) {
                           th1.text = resources.getStringArray(arreglo_de_preguntas!!)[s1].toString()

                           /*} else {
                               th1.text =
                                   resources.getStringArray(arreglo_de_preguntas!!)[armalas[s2]].toString()
                           }*/
                           visible(A)
                           visible(B)
                           visible(C)
                           visible(D)
                           visible(E)
                           visible(F)

                           invisible(sig)
                           invisible(btn_verQue)


                       }
                   }
               }

               fun visible(id_del_view: View) {

                   id_del_view.visibility = VISIBLE
               }

               fun invisible(id_del_view: View) {
                   id_del_view.visibility = INVISIBLE


               }

               fun toast(texto: String) {
if(toastSuperpuesto!=null){toastSuperpuesto!!.cancel()}
                   toastSuperpuesto = Toast.makeText(this, texto, Toast.LENGTH_SHORT)
                   toastSuperpuesto!!.setGravity(Gravity.BOTTOM, 0, 200)
                   toastSuperpuesto!!.show()

               }

               fun condiciones_views_pregunta() {
                   visible(scrollView2)
                   visible(A)
                   visible(B)
                   visible(C)
                   visible(D)
                   visible(E)
                   visible(F)
                   F.text = "F/G"
                   F.textSize = 19F
                   F.setTextColor(resources.getColor(R.color.grisCulo))
                   invisible(G)
                   invisible(sig)
                   invisible(btn_verQue)
                   invisible(btn_verImagen)
                   btn_verImagen.text = "V e r     I m a g e n"
                   invisible(photo_view)
                   layo.setBackgroundResource(R.drawable.fondock)
               }

               fun es_una_respuesta(): Boolean { //da true si es una respuesta lo que se muestra en el th1
                   var esNoEs = false
                   if (verRespuestaAnterior) {
                       esNoEs = true
                   } else if (
                       th1.text[1].toString() == " "
                       &&
                       th1.text[2].isUpperCase()
                       &&
                       th1.text[3].toString() == " "
                       &&
                       th1.text[4].isUpperCase()
                       ||
                       th1.text[2].toString() == " "
                       &&
                       th1.text[3].isUpperCase()
                       &&
                       th1.text[4].toString() == " "
                       &&
                       th1.text[5].isUpperCase()
                   ) {
                       esNoEs = true
                   }
                   return (esNoEs)

               }

               fun verRespuestaAnterior() {
                   if (sig.text == "Empecemos") {
                       var url =
                           "https://drive.google.com/file/d/1ygvVT0ICKkKZz77OyaeYEnRO12kQuVvI/view?usp=sharing"
                       val i_contribuciones = Intent(Intent.ACTION_VIEW)
                       i_contribuciones.setData(Uri.parse(url))
                       startActivity(i_contribuciones)
                   } else {
                       if (verRespuestaAnterior == false) { //si todavia no se toca se muestra la PREGUNTA
                           th1.text = resources.getStringArray(arreglo_de_preguntas!!)[s1 - 1].toString();
                           btn_verQue.text = "Ver Respuesta";verRespuestaAnterior =
                               true //indica que ya se toco

                           //marear al ButtonBackPressed!!
                       } else {//es decir ya se toco? esta en modo mostrar pregunta/boton que dice mostrar respuesta para volver, si entonces
                           btn_verQue.text = "Ver Pregunta"
                           val span=SpannableString(resources.getStringArray(arreglo_de_respuestas!!)[s1-1])
                           val green=ForegroundColorSpan(Color.GREEN)

                           if(resources.getStringArray(arreglo_de_respuestas!!)[s1-1][2].isUpperCase()) span.setSpan(green,2,3, Spanned.SPAN_INCLUSIVE_INCLUSIVE)

                           else if(resources.getStringArray(arreglo_de_respuestas!!)[s1-1][3].isUpperCase()) span.setSpan(green,3,4, Spanned.SPAN_INCLUSIVE_INCLUSIVE)

                           th1.text=span

                      /**  SAQUE ESTO   th1.text =
                      resources.getStringArray(arreglo_de_respuestas!!)[s1 - 1].toString() //muestra la respuesta, lo deja dnd estaba*/


                           verRespuestaAnterior = false //dice, mira que no esta pulsado el botón
                           //SI QUEDA PULSADO EN TRUE SE HACE FALSE SI ARRANCA ARRIBA, Y CON SIG Y PREG ANTE Y PREG POSTERIOR
                       }
                   }
               }

     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         val inflater = menuInflater
         inflater.inflate(R.menu.menu, menu)
         return true
     }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {

         var id = item.itemId
         when (id) {
             R.id.mas -> {
                 tamaño += 2f
             }
             R.id.menos -> {
                 tamaño -= 2f
             }
             R.id.bug -> {
                 var bug = "https://wa.me/+541128676833"
                 val i_contribuciones = Intent(Intent.ACTION_VIEW)
                 i_contribuciones.setData(Uri.parse(bug))
                 startActivity(i_contribuciones)


             }

             R.id.sig_pregunta -> {
                 sig.text = "Siguiente"
                 btn_verQue.text = "ver pregunta"
                 condiciones_views_pregunta()
                 var esNoEs = es_una_respuesta()

                 if (!esNoEs) //es pregunta?
                 {
                     s1++
                 }

                 if (s1 >= resources.getStringArray(arreglo_de_preguntas)
                         .count()
                 ) //preguntas en inmuno:60. su count es 61. Si el s1 es 61 se pasa, entonces si da 61 en este caso (inmuno agaugaguantaa) no pinta nada y vuelve
                 {
                     var i = Intent(this, MainActivity::class.java)
                     toast(
                         "Hiciste " + arbuenas.count()
                             .toString() + " bien."
                     )
                     startActivity(i)
                 } else {

                     th1.text = resources.getStringArray(arreglo_de_preguntas!!)[s1].toString()

                     when {
                         tema_seleccionado == "lacinfancia" && s1 == 17 -> {

                             btn_verImagen.text = "V e r     T a b l a";visible(btn_verImagen)

                         }
                         tema_seleccionado == "masculino" && s1 == 37 -> {

                             btn_verImagen.text = "V e r     T a b l a";visible(btn_verImagen)

                         }

                         s1 == respuesta_de_las_imagenes[s - 1] -> {
                             s--;btn_verImagen.text = "V e r     I m a g e n";visible(
                                 btn_verImagen
                             )
                         }
                         s1 == respuesta_de_las_imagenes[s] -> {
                             visible(btn_verImagen);btn_verImagen.text = "V e r     I m a g e n"
                         }
                         s1 == respuesta_de_las_imagenes[s + 1] -> {
                             s++;btn_verImagen.text = "V e r     I m a g e n";visible(
                                 btn_verImagen
                             )
                         }
                         else -> {
                             invisible(btn_verImagen)
                         }
                     }
                 }

                 verRespuestaAnterior = false

             }
             R.id.ant_pregunta -> {
                 if(th1.text[0].toString() == "1" && th1.text[1].toString() == " ") {}
                 else if (s1 >= 2) {
                     condiciones_views_pregunta()

                     var esNoEs = es_una_respuesta()
                     if (esNoEs) //es respuesta?
                     {
                         s1 -= 2
                     } else {
                         s1--
                     }

                     th1.text = resources.getStringArray(arreglo_de_preguntas!!)[s1].toString()

                     when {
                         tema_seleccionado == "lacinfancia" && s1 == 17 -> {

                             btn_verImagen.text = "V e r     T a b l a";visible(btn_verImagen)

                         }
                         tema_seleccionado == "masculino" && s1 == 37 -> {

                             btn_verImagen.text = "V e r     T a b l a";visible(btn_verImagen)

                         }
                         s1 == respuesta_de_las_imagenes[s - 1] -> {
                             s--;btn_verImagen.text = "V e r     I m a g e n";visible(
                                 btn_verImagen
                             )
                         }
                         s1 == respuesta_de_las_imagenes[s] -> {
                             visible(btn_verImagen);btn_verImagen.text = "V e r     I m a g e n"
                         }
                         s1 == respuesta_de_las_imagenes[s + 1] -> {
                             s++;btn_verImagen.text = "V e r     I m a g e n";visible(
                                 btn_verImagen
                             )
                         }
                         else -> {
                             invisible(btn_verImagen)
                         }
                     }

                 }

                 verRespuestaAnterior = false

             }
             R.id.estad -> {
                 var intento = Intent(this, Historia::class.java)
                 startActivity(intento)
             }
             /*R.id.random->{
                 //var random = Random.nextInt(1,61)
             //s1=random
                 haymalas=false//por si acaso que haya alguna falsa
                 if (!randombtn)
                 {
                 randombtn=true
                     sig.text="RANDOM"
                     toast("Modo Random Activated") //tuesta el toast en la altura que querias
                  /*  if(sig.isVisible)
                     {

                         //////////////////siguiente btn sin listeenr////
                         sig.text="Siguiente"

                         if (randombtn == true) {
                             sig.text="RANDOM"
                             random = Random.nextInt(1, 61);s1 = random

                         }

                         if (haymalas == false) {
                             th1.text = resources.getStringArray(R.array.inmunop)[s1].toString()
                             visible(A)
                             visible(B)
                             visible(C)
                             visible(D)
                             visible(E)
                             visible(F)
                             invisible(sig)
                         } else {
                             th1.text = resources.getStringArray(R.array.inmunop)[armalas[s2]].toString()
                             visible(A)
                             visible(B)
                             visible(C)
                             visible(D)
                             visible(E)
                             visible(F)
                             invisible(sig)
                         }
                         //////////////////////


                     } //siguiente btn sin listener*/
                 }

                 else {randombtn=false//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++DUDAS SOBRE SI LO HEREDA EN TIEMPO DE EJECUCION
                     sig.text="Siguiente"
                     toast("Modo Random Off") //tuesta el toast en la altura que querias
                  } //me lo marca apra resumir a un renglon voy a ver si asi anda y despue sloc ambio y pruebo

                //tv2.text=




             } //ojo aca a ver si toma el valor del random de arriba!!*/
         }


         th1.textSize = tamaño
         if (tamaño < 2) {
             tam = true
         }
         if (50 > tamaño && tamaño > 2) {
             tam = false
         } else if (tamaño == 2f && tam == false) {

                 toast("no me quiero ir señor Stark")

         }
         if (tamaño > 50f) {
             tam = true
         }
         if (tamaño == 50f && tam == false) {
             toast ("curiosa tecnica de microscopia")
         }

         return super.onOptionsItemSelected(item)
     }


}
/*QUE LE FALTA HACER:
-RANDOM: boton con forma de pez:
creo una random boolean geenral, el boton lo hace verdadero. inica en falso
si es true cambia el bvoton siguiente por Random y un  pecesito. Al tocarlo randomiza s1 y lo muestra en th1
La funcion abc... lo procesara como a cualqier numero y s1++, que no importa porque al tocar siguiente se randomiza de vuelta
*aca hay que hacer un if, porque si randomiza 60 y le suma 1, ah no es lo mismo porque queda 61 que lo lo lee nadie
*y despue slo randomiza al 61 solo, y lo randomiza entre 1 y 60 obviamente.
cuando lo quiero desactivar lo toco de vuelta (if true entonces false, if false entonces true)
Al desactivarlo deja el siguiente como estaba (anula el if en su interior) y sigue funcionando con la funcion abc... de siempre

buenos
1)interfaz, agregar boton
2) darle funcionalidad con el when id. Iftrueflasefalsetru. Y si es true poner al principio que siguiente actualiza el th1??
1
-CALIGRAFIA, COLORES, PINTURA DE FONDO: se lo cambio si le hago el sqlnos eque
-SELECCION DE PREGUNTA:edittext observable:
Es un edittext del mismo color que el fondo que al lado tiene una barra "/" y el count-1 de las preguntas para que sepan cual
es la ultima
Al tocar el numero de levanta el teclado, pongo un numero y lo observa al cambiar (como se hace). Al cambiar cambia s1 y
ademas lo muestra en el textView, y despues se lo pasa a la funcion abc... que sigue como si nada. Lo importante es ver como leerlo
en tiempo real. Se ultima capaz puedo agarrar el enter del teclodo, sino hago un boton que lo lea. Ademas al cambiar el s1 se tiene
que actualizar este "editText" para que cambie el numero de arriba
3
-Listo, el random, seleccion de pregunta, y limar detalles.ahh

AGREGAR PREGUNTAS DE LA CATEDRA dond lo pongo?
Que aparezca por ejemplo inmno en textview, y debajo un boton con preguntas de la catedra y otro con preguntas del robbins
ahhh
5
AGREGAR CONTRIBUCION
La foto del billete con geffner abre otra activity, en ella se muestran los link de pago
Como poner links?. Pongo links desde 20 pesos hasta 500 pesos. o Algun link de pedir dinero y aclaro en texto cuanto reciibo
Seria un button con la foto de gefner en el billete editado medio transparentado
6
INDEXACION
. Agregar "Pregunta" antes de cada pregunta (seria despues del item)
. Agregar "Respuesta" antes de cada respuesta (si queda bien)- no scar el numero del princioio hasta estar 100%segura de que anda!-
. Indexar un poco el cuestionario no debe ser muy dificil
8
HACER VIDEO EXPLICATIVO
Lo grabo con la pantalla fijandome que quede de buena resoluciuon
.Explicar
Lo de porque la contribucion, que es por el trabajho mostar el codig "no es x la infoamacin la info a la tene,mos es por e trabajo"
Monedilla para el desarrolador
Explicar que estaran todos los temas, que el libro es largo, explicar que libro es dejarlo en pdf
Explicar como funciona
Explicar que va adecir "peligrosa no se que verga"

PASAR A APK
10
*/


/*fun main() {
    //base te texto, primerNumero, segunndoNumero
    mech("Hola",1,10000)


}

fun mech(base:String, primerNumero:Int, segundoNumero:Int){

     var array=arrayListOf<String>()

    for (x in primerNumero..segundoNumero){
        array.add(base+x.toString())

    }
    println(array)

}*/