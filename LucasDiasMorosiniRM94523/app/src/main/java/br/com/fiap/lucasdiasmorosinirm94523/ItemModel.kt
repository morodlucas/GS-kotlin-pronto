package br.com.fiap.lucasdiasmorosinirm94523

data class ItemModel(val praiaName: String, val estadoName: String, val cidadeName: String,  val onRemove: (ItemModel) -> Unit)