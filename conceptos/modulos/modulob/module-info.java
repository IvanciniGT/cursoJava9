module modulob { // define un módulo
    
    exports paquete2; // Paquetes que exporta el modulo
                      // Y por ende, que podrán ser consultados extarnamente a este modulo
    
    provides paquete2.Interfaz with 
        paquete2.impl.ClaseQueImplementaInterfaz1,
        paquete2.impl.ClaseQueImplementaInterfaz2;  // Inyeccion de DEPENDENCIAS
                                                    // Spring se consigue inyeccion de dependencias a través de otro concepto INVERSION DE CONTROL !
}