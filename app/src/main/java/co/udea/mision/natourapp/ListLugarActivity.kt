package co.udea.mision.natourapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ListLugarActivity : AppCompatActivity() {

    private lateinit var listadelugares: ArrayList<LugarItem>
    private lateinit var lugaresAdapter: ListLugaresAdapter
    private lateinit var lugaresRecycleview: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_lugares)
        lugaresRecycleview = findViewById(R.id.lugares_recycle_view)
        // listadelugares=createMockLugares()
        listadelugares = loadMochFromJson()
        lugaresAdapter = ListLugaresAdapter(listadelugares)
        //lugaresRecycleview.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        lugaresRecycleview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresAdapter
            setHasFixedSize(false)
        }
        lugaresRecycleview.adapter = lugaresAdapter
    }

    private fun loadMochFromJson(): ArrayList<LugarItem> {
        var listaLugaresString: String =
            applicationContext.assets.open("lugaresTuristicos.json").bufferedReader()
                .use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(listaLugaresString, Lugar::class.java)
        return data
    }

// private  fun createMockLugares():ArrayList<Lugar>{
// return arrayListOf(
// Lugar(
// nombre = "Cascada fin del mundo",
// descripcion = "La Cascada Fin del Mundo se encuentra en medio de la selva amazónica, a \n" +
// "unos pocos kilómetros del municipio de Mocoa, y totalmente rodeada de aire puro y de un paisaje virgen cargado de cientos de especies de flora y fauna.\n",
// calificacion = 4.8,
// urlImage = "https://www.dccomics.com/sites/default/files/styles/character_thumb_160x160/public/Char_Profile_Superboy_5c5a362fd8f1b1.94225098.jpg"
//
// ),
// Lugar(
// nombre = "Centro Experimental Amazónico (CEA)",
// descripcion = "El Centro Experimental Amazónico, es un observatorio ambiental que promueve el conocimiento científico y tradicional en aras de mejorar la calidad de vida de los habitantes de la región y de los turistas que nos visitan.",
// calificacion = 3.7,
// urlImage = "https://github.com/carfolacam98/Natourapp/blob/master/app/src/main/res/drawable/etnoturistico.jpg"
// ),
// Lugar(
// nombre = "Centro Etnoturístico Inga MAITUS WASI ",
// descripcion = " Es un centro de sanación donde se preserva el arte, la cultura y en especial la medicina tradicional en especial del pueblo inga, un lugar sagrado donde se busca la purificación del cuerpo y espíritu humano para así preservar la naturaleza, la salud, la unidad familiar y en especial la paz y tranquilidad de quienes nos visitan.",
// calificacion = 4.1,
// urlImage = "https://github.com/carfolacam98/Natourapp/blob/master/app/src/main/res/drawable/canon.jpg"
// ),
// Lugar(
// nombre = "Mariposario paway",
// descripcion = "En el Mariposario Paway podemos conocer el fantástico mundo de las mariposas en su área de vuelo como el proceso que llevan en el laboratorio con la finalidad de poder tener un conocimiento más amplio.",
// calificacion = 3.0,
// urlImage = "https://github.com/carfolacam98/Natourapp/blob/master/app/src/main/res/drawable/amazonico.jpg"
// ),
// Lugar(
// nombre = "Cavernas de Licamancha",
// descripcion = " Durante miles de años, el contacto constante de las rocas con cursos subterráneos de agua las erosionó y creó cavidades internas en ellas, con diversas formas ideales para la práctica de la espeleología. Las cuevas están al norte de Mocoa, en donde hay una corriente de agua que desemboca en el río Caquetá.",
// calificacion = 4.4,
// urlImage = "https://github.com/carfolacam98/Natourapp/blob/master/app/src/main/res/drawable/mariposario.jpg"
// )
//
// )
// }
 }