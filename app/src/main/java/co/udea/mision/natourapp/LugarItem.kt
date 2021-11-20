package co.udea.mision.natourapp


import com.google.gson.annotations.SerializedName

data class LugarItem(
    @SerializedName("caliicacion")
    val caliicacion: Double,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("urlImage")
    val urlImage: String
)