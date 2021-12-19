package ru.mrlargha.sberhealthtest.model

/**
 * Один препарат (медикамент)
 *
 * @property id id препарата
 * @property title назавание препарата
 * @property icon ссылка на иконку препарата
 * @property isReadyForKids можно ли использовать детям ???
 */
data class Medicine(val id: Int, val title: String, val icon: String, val isReadyForKids: Boolean)
