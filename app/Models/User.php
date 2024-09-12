<?php

namespace App\Models;

// use Illuminate\Contracts\Auth\MustVerifyEmail;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;
use Laravel\Sanctum\HasApiTokens;

class User extends Authenticatable
{
    use HasApiTokens, HasFactory, Notifiable;

    /**
     * The attributes that are mass assignable.
     *
     * @var array<int, string>
     */
    protected $fillable = [
        'trol_id',
        'nombre',
        'primer_apellido',
        'segundo_apellido',
        'usuario',
        'correo',
        'contrasenia',
        'estado',
    ];

    protected $atributes = [
        'estado' => 1,
    ];

    /**
     * The attributes that should be hidden for serialization.
     *
     * @var array<int, string>
     */
    protected $hidden = [
        'password',
        'remember_token',
    ];

    /**
     * The attributes that should be cast.
     *
     * @var array<string, string>
     */
    protected $casts = [
        'email_verified_at' => 'datetime',
        'password' => 'hashed',
    ];

    public function admin()
    {
        return $this->belongsTo(Tusuario_admin::class, 'tusuario_admin_id', 'id');
    }

    public function nutriologo()
    {
        return $this->belongsTo(Tusuario_nutriologo::class, 'tusuario_nutriologo_id', 'id');
    }

    public function paciente()
    {
        return $this->belongsTo(Tusuario_paciente::class, 'tusuario_paciente_id', 'id');
    }

    public function articulos()
    {
        return $this->hasMany(Tarticulos::class, 'nutriologo_id', 'id');
    }

    public function consulta()
    {
        return $this->hasMany(Tdatos_consulta::class, 'nutriologo_id', 'id');
        return $this->hasMany(Tdatos_consulta::class, 'paciente_id', 'id');
    }
}