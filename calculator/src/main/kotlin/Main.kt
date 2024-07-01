package com.baimsg

import com.baimsg.com.baimsg.calcuator.MixedOperations
import java.io.File
import java.security.MessageDigest

/**
 * Create by Baimsg on 2024/6/22
 *
 **/
fun main() {
    MixedOperations.calculate(" 2^8 -(10-9)+(100/1)") {
        println(it)
    }

//    val files = mutableMapOf<String, File>()
//    files.recursion(File("../../白先生/设计素材/svg"))
}


@OptIn(ExperimentalStdlibApi::class)
private fun MutableMap<String, File>.recursion(path: File) {
    path.listFiles()?.forEach { file ->
        if (file.isFile) {
            val messageDigest = MessageDigest.getInstance("MD5")
            val hash = messageDigest.digest(file.readBytes()).toHexString()
            checkFile(hash, file)
        } else {
            recursion(file)
        }
    }
}

private fun MutableMap<String, File>.checkFile(hash: String, file: File) {
    if (this.containsKey(hash)) {
        println("hash = $hash, oldFile = ${this[hash]}, newFile = $file")
    } else {
        this[hash] = file
    }
}