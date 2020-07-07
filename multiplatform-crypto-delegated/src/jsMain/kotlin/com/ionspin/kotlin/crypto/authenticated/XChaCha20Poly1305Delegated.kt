package com.ionspin.kotlin.crypto.authenticated

import com.ionspin.kotlin.crypto.InvalidTagException
import com.ionspin.kotlin.crypto.getSodium
import com.ionspin.kotlin.crypto.util.hexColumsPrint
import ext.libsodium.com.ionspin.kotlin.crypto.toUByteArray
import ext.libsodium.com.ionspin.kotlin.crypto.toUInt8Array
import org.khronos.webgl.Uint8Array

/**
 * Created by Ugljesa Jovanovic
 * ugljesa.jovanovic@ionspin.com
 * on 25-Jun-2020
 */

/**
 * Created by Ugljesa Jovanovic
 * ugljesa.jovanovic@ionspin.com
 * on 14-Jun-2020
 */
actual class XChaCha20Poly1305Delegated internal actual constructor() {
    actual companion object {
        actual fun encrypt(
            key: UByteArray,
            nonce: UByteArray,
            message: UByteArray,
            additionalData: UByteArray
        ): UByteArray {
            val encrypted = getSodium().crypto_aead_xchacha20poly1305_ietf_encrypt(
                message.toUInt8Array(),
                additionalData.toUInt8Array(),
                Uint8Array(0),
                nonce.toUInt8Array(),
                key.toUInt8Array()
            )
            return encrypted.toUByteArray()
        }

        actual fun decrypt(
            key: UByteArray,
            nonce: UByteArray,
            ciphertext: UByteArray,
            additionalData: UByteArray
        ): UByteArray {
            val decrypted = getSodium().crypto_aead_xchacha20poly1305_ietf_decrypt(
                Uint8Array(0),
                ciphertext.toUInt8Array(),
                additionalData.toUInt8Array(),
                nonce.toUInt8Array(),
                key.toUInt8Array()
            )
            return decrypted.toUByteArray()
        }
    }

    var state : dynamic = null

    actual fun initializeForEncryption(key: UByteArray) : UByteArray {
        println("Initializaing for encryption")
        val stateAndHeader = getSodium().crypto_secretstream_xchacha20poly1305_init_push(key.toUInt8Array())
        val state = stateAndHeader.state
        val header = stateAndHeader.header
        console.log(state)
        console.log(header)
        println("Done initializaing for encryption")
        return header
    }

    actual fun initializeForDecryption(key: UByteArray, header: UByteArray) {

    }

    internal actual constructor(
        key: UByteArray,
        testState: UByteArray,
        testHeader: UByteArray
    ) : this() {
        state = getSodium().crypto_secretstream_xchacha20poly1305_init_pull(testHeader.toUInt8Array(), key.toUInt8Array())
        console.log(state)
        println("Done initializaing test state")
    }

    actual fun encrypt(data: UByteArray, additionalData: UByteArray): UByteArray {
        val encrypted = getSodium().crypto_secretstream_xchacha20poly1305_push(state, data.toUInt8Array(), additionalData.toUInt8Array(), 0U)
        return encrypted.toUByteArray()
    }

    actual fun decrypt(data: UByteArray, additionalData: UByteArray): UByteArray {
        val decryptedWithTag = getSodium().crypto_secretstream_xchacha20poly1305_pull(state, data.toUInt8Array(), additionalData.toUInt8Array())
        val decrypted = decryptedWithTag.message as Uint8Array
        val validTag = decryptedWithTag.tag as UInt

        if (validTag != 0U) {
            println("Tag validation failed")
            throw InvalidTagException()
        }
        return decrypted.toUByteArray()
    }



}
