# Usa una imagen oficial de PHP con extensiones necesarias
FROM php:8.2-fpm

# Instala dependencias del sistema
RUN apt-get update && apt-get install -y \
    zip unzip git curl libpng-dev libonig-dev libxml2-dev \
    && docker-php-ext-install pdo_mysql mbstring exif pcntl bcmath gd

# Instala Composer
COPY --from=composer:latest /usr/bin/composer /usr/bin/composer

# Establece el directorio de trabajo
WORKDIR /var/www

# Copia los archivos del proyecto necesarios para Composer
COPY composer.json composer.lock ./

# Crea el directorio vendor y ajusta permisos
RUN mkdir -p /var/www/vendor && chown -R www-data:www-data /var/www

# Instala dependencias de PHP (composer)
RUN su www-data -s /bin/sh -c "composer install --prefer-dist --no-dev --optimize-autoloader"

# Copia el resto de los archivos del proyecto
COPY . .

# Configuración de permisos
RUN chown -R www-data:www-data /var/www \
    && chmod -R 775 /var/www/storage /var/www/bootstrap/cache

# Exponer el puerto
EXPOSE 8000

# Comando por defecto para ejecutar php-fpm en primer plano
CMD ["php-fpm", "-F"]
