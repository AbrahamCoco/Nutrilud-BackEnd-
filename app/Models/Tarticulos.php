<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Tarticulos extends Model
{
    use HasFactory;

    protected $fillable = [
        'nutriologo_id',
        'titulo',
        'contenido'
    ];

    public function nutriologo()
    {
        return $this->belongsTo(Tusuario_nutriologo::class, 'nutriologo_id');
    }
}
