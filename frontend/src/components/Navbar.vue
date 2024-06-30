<template>
    <nav class="navbar">
        <div class="navbar-container">
            <div class="hamburger-menu" @click="toggleMenu">
                <span class="hamburger-icon"></span>
                <span class="hamburger-icon"></span>
                <span class="hamburger-icon"></span>
            </div>
            <div class="navbar-left">
                <ul :class="{ 'navbar-links': true, open: menuOpen }" @click="closeMenu">
                    <li>
                        <router-link to="/home" class="nav-link">Home</router-link>
                    </li>
                    <li>
                        <router-link to="/shop" class="nav-link">Shop</router-link>
                        <ul>
                            <li><router-link to="/shop/boards" class="nav-link">Boards</router-link></li>
                            <li><router-link to="/shop/wetsuits" class="nav-link">Wetsuits</router-link></li>
                            <li><router-link to="/shop/accessories" class="nav-link">Accessories</router-link></li>
                        </ul>
                    </li>
                    <li><a href="#about">About</a></li>
                    <li>
                        <router-link to="/contact" class="nav-link">Contact</router-link>
                    </li>
                </ul>
            </div>
            <div class="navbar-right">
                <font-awesome-icon icon="fa-solid fa-cart-shopping" />
            </div>
        </div>
    </nav>
</template>

<script setup lang="ts">
import { ref, onMounted, onUnmounted } from 'vue';

const menuOpen = ref(false);
// const subMenuOpen = ref(false);

const toggleMenu = () => {
    menuOpen.value = !menuOpen.value;
};

const closeMenu = () => {
    menuOpen.value = false;
};


const handleResize = () => {
    if (window.innerWidth >= 768) {
        closeMenu();
    }
};

const handleClickOutside = (event: Event) => {
    const target = event.target as HTMLElement;
    if (!target.closest('.navbar-container')) {
        closeMenu();
    }
};

onMounted(() => {
    window.addEventListener('resize', handleResize);
    document.addEventListener('click', handleClickOutside);
});

onUnmounted(() => {
    window.removeEventListener('resize', handleResize);
    document.removeEventListener('click', handleClickOutside);
});
</script>

<style scoped>
.navbar {
    background-color: #333;
    padding: 10px 20px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    color: white;
}

.navbar-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100%;
}

.hamburger-menu {
    display: none;
    flex-direction: column;
    cursor: pointer;
}

.hamburger-icon {
    width: 25px;
    height: 3px;
    background-color: white;
    margin: 4px 0;
    transition: 0.4s;
}


.navbar-left {
    display: flex;
    align-items: center;
}



li {
  display: inline-block;
}

a {
  color: #000;
  text-decoration: none;
  padding: 10px;
}

a:hover {
  background-color: #ccc;
}

ul ul {
  display: none;
}

li:hover ul {
  display: block;
}


.navbar-links {
    list-style: none;
    display: flex;
    gap: 20px;
    margin: 0;
    padding: 0;
}

.navbar-links.open {
    display: block;
}

.navbar-links li a {
    color: white;
    text-decoration: none;
    transition: color 0.3s;
}

.navbar-links li a:hover {
    color: #ddd;
}

.submenu {
    display: none;
    /* position: absolute; */
    top: 100%;
    left: 0;
    background-color: #444;
    list-style: none;
    padding: 0;
    margin: 0;
    z-index: 1;
}

.submenu.open {
    display: block;
}

.submenu li {
    width: 100%;
}

.submenu li a {
    padding: 10px 20px;
    display: block;
    color: white;
    text-decoration: none;
    transition: background-color 0.3s;
}

.submenu li a:hover {
    background-color: #555;
}


.navbar-right {
    margin-left: auto;
    display: flex;
    align-items: center;
}

@media (max-width: 768px) {
    .hamburger-menu {
        display: flex;
    }

    .navbar-links {
        display: none;
        position: absolute;
        top: 60px;
        left: 0;
        width: 100%;
        background-color: #333;
        flex-direction: column;
        align-items: center;
        gap: 10px;
    }

    .navbar-links.open {
        display: flex;
    }

    .cart-icon {
        position: absolute;
        right: 20px;
    }
}
</style>
