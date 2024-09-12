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
        Schema::create('tusuario_nutriologos', function (Blueprint $table) {
            $table->id();
            $table->string('descripcion');
            $table->text('foto')->nullable();
            $table->string('direccion');
            $table->string('telefono');
            $table->integer('cedula_profesional');
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('tusuario_nutriologos');
    }
};