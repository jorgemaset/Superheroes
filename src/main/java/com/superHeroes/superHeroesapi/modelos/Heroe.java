package com.superHeroes.superHeroesapi.modelos;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Heroe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nombre;
    private String poder;

    public long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getPoder() {
        return this.poder;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Heroe)) return false;
        final Heroe other = (Heroe) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$nombre = this.getNombre();
        final Object other$nombre = other.getNombre();
        if (this$nombre == null ? other$nombre != null : !this$nombre.equals(other$nombre)) return false;
        final Object this$poder = this.getPoder();
        final Object other$poder = other.getPoder();
        if (this$poder == null ? other$poder != null : !this$poder.equals(other$poder)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Heroe;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $nombre = this.getNombre();
        result = result * PRIME + ($nombre == null ? 43 : $nombre.hashCode());
        final Object $poder = this.getPoder();
        result = result * PRIME + ($poder == null ? 43 : $poder.hashCode());
        return result;
    }

    public String toString() {
        return "Heroe(id=" + this.getId() + ", nombre=" + this.getNombre() + ", poder=" + this.getPoder() + ")";
    }
}
