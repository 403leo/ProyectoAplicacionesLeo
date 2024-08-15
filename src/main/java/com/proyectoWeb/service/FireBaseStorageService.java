
package com.proyectoWeb.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface FireBaseStorageService {
    // La carpeta es donde se quiere que se coloque la imagen.
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "fir-proyecto-890c5.appspot.com";

    //Esta es la ruta básica de este proyecto Techshop
    final String rutaSuperiorStorage = "FirebaseProyecto";

    //Ubicación donde se encuentra el archivo de configuración Json en other Sources.
    final String rutaJsonFile = "firebase";
    
    //El nombre del archivo Json
    final String archivoJsonFile = "fir-proyecto-890c5-firebase-adminsdk-qopuo-7cc42dd3de.json";
}
