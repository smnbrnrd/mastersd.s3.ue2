package fr.urn.sime.coffeeapp.model;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
public class AuthentificationInterceptor {

    // Méthode pour vérifier si l'utilisateur est authentifié
    private boolean isUserAuthenticated() {
        // Logique d'authentification ici
        return false; 
    }
    
    @AroundInvoke
    public Object checkAuthentication(InvocationContext context) throws Exception {
        if (!isUserAuthenticated()) {
            // Rediriger vers la page de connexion
            System.out.println("AuthentificationInterceptor:: Utilisateur non authentifié. Redirection vers la page de connexion...");
        }
        return context.proceed();
    }
}
