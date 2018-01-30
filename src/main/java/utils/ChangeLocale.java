package utils;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * L'annotation ManagedBean fait de la classe Java ChangeLocale un bean reconnu
 * par JSF. Un bean est identifié par un nom. Celui-ci peut être fixé par
 * l'attribut name de l'annotation : @ManagedBean(name= "xx "). En l'absence de
 * l'attribut name, le nom de la classe est utilisé en passant son premier
 * caractère en minuscule. Le nom du bean ChangeLocale est donc changeLocale. On
 * prêtera attention au fait que l'annotation ManagedBean appartient au package
 * javax.faces.bean.ManagedBean et non au package javax.annotations.ManagedBean.
 *
 * L'annotation SessionScoped fixe la portée du bean. Il y en a plusieurs. Nous
 * utiliserons couramment les trois suivantes :
 *
 * • RequestScoped : la durée de vie du bean est celle du cycle demande
 * navigateur / réponse serveur. Si pour traiter une nouvelle requête du même
 * navigateur ou d'un autre, ce bean est de nouveau nécessaire, il sera
 * instancié de nouveau,
 *
 * • SessionScoped : la durée de vie du bean est celle de la session d'un client
 * particulier. Le bean est créé initialement pour les besoins de l'une des
 * requêtes de ce client. Il restera ensuite en mémoire dans la session de ce
 * client. Un tel bean mémorise en général des données propres à un client
 * donné. Il sera détruit lorsque la session du client sera détruite,
 *
 * • ApplicationScoped : la durée de vie du bean est celle de l'application
 * elle-même. Un bean avec cette durée de vie est le plus souvent partagé par
 * tous les clients de l'application. Il est en général initialisé au début de
 * l'application.
 *
 * On notera que la classe [ChangeLocale] implémente l'interface [Serializable].
 * C'est obligatoire pour les beans de portée Session que le serveur web peut
 * être amené à sérialiser dans des fichiers.
 *
 * IMPORTANT : le bean B qui contient le gestionnaire d'événements de la page
 * JSF P est aussi souvent celui qui contient le modèle M de cette page. Cela
 * signifie que le bean B contient des champs qui seront initialisés par les
 * valeurs saisies dans la page P. Cela sera fait par le contrôleur [Faces
 * Servlet] avant que le gestionnaire d'événements du bean B ne soit appelé. Ce
 * gestionnaire aura donc accès, via les champs du bean B auquel il appartient,
 * aux valeurs saisies par le client dans le formulaire et pourra les traiter.
 *
 * @author domin
 */
@ManagedBean
@SessionScoped
public class ChangeLocale implements Serializable {
    // la locale des pages

    private String locale = "fr";

    public ChangeLocale() {
    }

    /**
     * Considéré comme un gestionnaire d'évènements (voir index.xhtml).
     *
     * • il ne reçoit aucun paramètre. Nous verrons qu'il peut néanmoins avoir
     * accès à la requête du client, • il doit rendre un résultat C de type
     * String. Cette chaîne de caractères C peut être : • soit le nom d'une page
     * JSF du projet ; • soit un nom défini dans les règles de navigation du
     * fichier [faces-config.xml] et associé à une page JSF du projet ; • soit
     * un pointeur null, si le navigateur client ne doit pas changer de page
     *
     * @return
     */
    public String setFrenchLocale() {
        locale = "fr";
        return null;
    }

    public String setEnglishLocale() {
        locale = "en";
        return null;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

}
