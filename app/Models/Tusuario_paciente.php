<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Tusuario_paciente extends Model
{
    use HasFactory;

    protected $fillable = [
        'id_paciente',
        'foto',
        'telefono',
        'fecha_nacimiento',
        'sexo',
        'alergias',
    ];

    public function user()
    {
        return $this->belongsTo(User::class, 'id_paciente', 'id');
    }
}
