// Import MongoDB client library
const { MongoClient } = require('mongodb');
require('dotenv').config();

// MongoDB connection URL
const url = process.env.MONGODB_URI || 'mongodb://mongodb:27017';
 
// Database Name
const dbName = 'mysurfboards';

// Define migration logic
async function migrate() {
    const client = new MongoClient(url);

     try {
        await client.connect();

        const db = client.db(dbName);

        // Perform database operations
        await db.collection('boards').insertMany([
            { "name": "Hoodoo Swallow", "price": 1000, "type": "Fish", "brand": "Delight Alliance" },
            { "name": "Lost Puddle Jumper", "price": 800, "type": "Hybrid", "brand": "Lost Surfboards" },
            { "name": "Firewire Evo", "price": 900, "type": "Fish", "brand": "Firewire Surfboards" },
            { "name": "JS Monsta Box", "price": 850, "type": "Thruster", "brand": "JS Industries" },
            { "name": "Haydenshapes Hypto Krypto", "price": 1000, "type": "Hybrid", "brand": "Haydenshapes" },
            { "name": "Channel Islands Fever", "price": 950, "type": "Performance Shortboard", "brand": "Channel Islands" },
            { "name": "Surftech Takayama Scorpion", "price": 1100, "type": "Longboard", "brand": "Surftech" },
            { "name": "Rusty Yes Thanks", "price": 850, "type": "Hybrid", "brand": "Rusty Surfboards" },
            { "name": "Haydenshapes Holy Grail", "price": 950, "type": "Performance Shortboard", "brand": "Haydenshapes" },
            { "name": "Firewire Slater Designs Omni", "price": 1050, "type": "Hybrid", "brand": "Firewire Surfboards" },
            { "name": "Lost Crowd Killer", "price": 900, "type": "Hybrid", "brand": "Lost Surfboards" }
        ]);

         // Perform database operations
         await db.collection('wetsuits').insertMany([
            { "name": "O'Neill Hyperfreak", "price": 300, "thickness": "4/3 mm", "brand": "O'Neill" },
            { "name": "Rip Curl Flashbomb", "price": 400, "thickness": "5/4 mm", "brand": "Rip Curl" },
            { "name": "Quiksilver Highline", "price": 350, "thickness": "5/4 mm hooded", "brand": "Quiksilver" },
            { "name": "Billabong Furnace", "price": 380, "thickness": "4/3 mm", "brand": "Billabong" },
            { "name": "Xcel Drylock", "price": 420, "thickness": "5/4 mm", "brand": "Xcel" },
            { "name": "Patagonia R4 Yulex", "price": 450, "thickness": "5/4 mm hooded", "brand": "Patagonia" },
            { "name": "O'Neill Psycho Tech", "price": 370, "thickness": "4/3 mm", "brand": "O'Neill" },
            { "name": "Rip Curl E-Bomb", "price": 390, "thickness": "5/4 mm", "brand": "Rip Curl" },
            { "name": "Quiksilver Syncro", "price": 320, "thickness": "5/4 mm hooded", "brand": "Quiksilver" },
            { "name": "Billabong Absolute X", "price": 310, "thickness": "4/3 mm", "brand": "Billabong" },
            { "name": "Xcel Infiniti", "price": 430, "thickness": "5/4 mm", "brand": "Xcel" }
        ]);
        
        await db.collection('accessories').insertMany([
            { "name": "O'Neill Psycho Tech Gloves", "price": 50, "type": "Gloves", "brand": "O'Neill" },
            { "name": "Rip Curl Flashbomb Gloves", "price": 60, "type": "Gloves", "brand": "Rip Curl" },
            { "name": "Quiksilver Syncro Gloves", "price": 45, "type": "Gloves", "brand": "Quiksilver" },
            { "name": "Billabong Furnace Gloves", "price": 55, "type": "Gloves", "brand": "Billabong" },
            { "name": "Xcel Drylock Gloves", "price": 65, "type": "Gloves", "brand": "Xcel" },
            { "name": "Patagonia R4 Yulex Gloves", "price": 70, "type": "Gloves", "brand": "Patagonia" },
            { "name": "O'Neill Psycho Tech Boots", "price": 70, "type": "Boots", "brand": "O'Neill" },
            { "name": "Rip Curl Flashbomb Boots", "price": 80, "type": "Boots", "brand": "Rip Curl" },
            { "name": "Quiksilver Highline Boots", "price": 75, "type": "Boots", "brand": "Quiksilver" },
            { "name": "Billabong Furnace Boots", "price": 85, "type": "Boots", "brand": "Billabong" },
            { "name": "Xcel Drylock Boots", "price": 90, "type": "Boots", "brand": "Xcel" }
        ]);
        

        console.log('Migration successful');
    } finally {
        await client.close();
    }
}

// Run migration
migrate();
