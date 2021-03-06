package cafe.adriel.satchel.storer.file

import cafe.adriel.satchel.ktx.isEmpty
import cafe.adriel.satchel.storer.SatchelStorer
import java.io.File

class FileSatchelStorer(private val file: File) : SatchelStorer {

    override suspend fun store(data: ByteArray) =
        file.writeBytes(data)

    override fun retrieve(): ByteArray =
        when {
            file.isEmpty -> ByteArray(0)
            else -> file.readBytes()
        }
}
