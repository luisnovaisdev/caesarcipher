package de.kenbi.caesarcipher.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val plainAlphabet = "abcdefghijklmnopqrstuvwxyz"

    fun encode(stringToEncode: String, shift: Int): String {

        val plainAlphabetSplit = plainAlphabet.chunked(1)

        val stringToEncodeSplit = stringToEncode.lowercase().chunked(1)

        val stringEncoded = stringToEncodeSplit.map { char ->

            val foundCharIndex = plainAlphabetSplit.indexOf(char)

            if(foundCharIndex == -1) {
                return@map char
            }

            var newCharIndex = foundCharIndex - shift

            if(newCharIndex < 0){
                newCharIndex += plainAlphabetSplit.size
            }

            val newChar = plainAlphabetSplit[newCharIndex]

            newChar

        }

        return stringEncoded.joinToString("")
    }

}