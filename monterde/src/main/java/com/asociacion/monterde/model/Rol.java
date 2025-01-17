package com.asociacion.monterde.model;

/**
 * Enumeración para representar los roles de los miembros.
 *
 * Define los diferentes cargos que pueden ocupar los miembros de la asociación.
 */
public enum Rol {
    PRESIDENTE("Presidente"),
    TESORERO("Tesorero"),
    SECRETARIO("Secretario"),
    MIEMBRO("Miembro");

    private final String displayName;

    /**
     * Constructor para asignar un nombre legible al rol.
     *
     * @param displayName Nombre legible del rol.
     */
    Rol(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Obtiene el nombre legible del rol.
     *
     * @return Nombre del rol.
     */
    public String getDisplayName() {
        return displayName;
    }
}
