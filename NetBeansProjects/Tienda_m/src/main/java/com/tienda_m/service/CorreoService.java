/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda_m.service;

import jakarta.mail.MessagingException;

public interface CorreoService {
    //La firma del metodo para enviar correos html
    public void enviarCorreoHtml(
            String para,
            String asunto,
            String contenidoHtml) 
            throws MessagingException;
    
}
