/// <reference types="cypress" />

describe('SurfShop App', () => {
  beforeEach(() => {
    cy.visit('http://localhost:5173'); 
  });

  it('should display the Vue logo', () => {
     cy.get('.logo.vue').should('be.visible');
  });

  it('should display the SurfShop component with the message', () => {
     cy.contains('h1', 'Surf shop').should('be.visible');
  });

  it('should have search inputs', () => {
     cy.get('input[placeholder="Search by name"]').should('be.visible');
    cy.get('input[placeholder="Search by brand"]').should('be.visible');
    cy.get('input[placeholder="Search by type"]').should('be.visible');
  });

  it('should perform a search by name', () => {
    cy.get('input[placeholder="Search by name"]').type('Hoodoo Swallow'); 
    cy.get('button').contains('Search').click();

    cy.get('ul').should('contain', 'Hoodoo Swallow'); 
  });

  it('should perform a search by brand', () => {
    cy.get('input[placeholder="Search by brand"]').type('Delight Alliance'); 
    cy.get('button').contains('Search').click();

    cy.get('ul').should('contain', 'Delight Alliance'); 
  });

  it('should perform a search by type', () => {
    cy.get('input[placeholder="Search by type"]').type('Fish'); 
    cy.get('button').contains('Search').click();

    cy.get('ul').should('contain', 'Fish'); 
  });
});
