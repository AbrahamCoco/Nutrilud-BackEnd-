<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('tusuario_pacientes', function (Blueprint $table) {
            $table->id();
            $table->text('foto')->nullable();
            $table->string('telefono');
            $table->datetime('fecha_nacimiento');
            $table->string('sexo');
            $table->string('alergias');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('tusuario_pacientes');
    }
};