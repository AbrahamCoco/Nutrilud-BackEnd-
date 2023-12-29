<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Tusuario_paciente extends Model
{
    use HasFactory;

    protected $fillable = [
        'paciente_id',
        'foto',
        'telefono',
        'fecha_nacimiento',
        'sexo',
        'alergias',
    ];

    public function user()
    {
        return $this->belongsTo(User::class, 'user_id', 'id');
    }

    public function consulta()
    {
        return $this->hasMany(Tdatos_consulta::class, 'paciente_id', 'id');
    }
}
