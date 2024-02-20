FROM php:8.1-fpm

WORKDIR /var/www/html

# Instalar dependencias de Laravel
RUN apt-get update && apt-get install -y \
    git \
    unzip \
    libzip-dev \
    && docker-php-ext-install zip pdo pdo_mysql

# Instalar Composer
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer

# Copiar archivos del proyecto
COPY . .

# Instalar dependencias de PHP
RUN composer install

# Configurar Laravel (puedes necesitar más comandos aquí, dependiendo de tu configuración)
RUN php artisan key:generate
RUN php artisan config:cache

EXPOSE 8000

CMD ["php", "artisan", "serve", "--host", "0.0.0.0", "--port", "8000"]