// Import MongoDB client library
const { MongoClient } = require('mongodb');

// MongoDB connection URL
const url = 'mongodb://localhost:27017';

// Database Name
const dbName = 'mysurfboards';

// Define migration logic
async function migrate() {
    const client = new MongoClient(url);

    try {
        await client.connect();

        const db = client.db(dbName);

        // Perform database operations
        await db.collection('items').insertMany([
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

        console.log('Migration successful');
    } finally {
        await client.close();
    }
}

// Run migration
migrate();
