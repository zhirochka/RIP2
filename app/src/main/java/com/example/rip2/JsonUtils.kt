package com.example.rip2

import android.content.Context
import org.json.JSONArray
import java.io.IOException

class JsonUtils {
  companion object {
    fun loadJsonFromAsset(context: Context, fileName: String): JSONArray? {
      val json: String?
      try {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer, Charsets.UTF_8)
      } catch (e: IOException) {
        e.printStackTrace()
        return null
      }

      return JSONArray(json)
    }
  }
}