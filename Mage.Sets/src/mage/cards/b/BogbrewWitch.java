/*
 *  Copyright 2010 BetaSteward_at_googlemail.com. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */
package mage.cards.b;

import java.util.UUID;
import mage.MageInt;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.search.SearchLibraryPutInPlayEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Outcome;
import mage.constants.Zone;
import mage.filter.FilterCard;
import mage.filter.predicate.Predicates;
import mage.filter.predicate.mageobject.NamePredicate;
import mage.target.common.TargetCardInLibrary;

/**
 *
 * @author LevelX2
 */
public class BogbrewWitch extends CardImpl {

    private static final FilterCard filter = new FilterCard("card named Festering Newt or Bubbling Cauldron");
    static {
        filter.add(Predicates.or(new NamePredicate("Festering Newt"), new NamePredicate("Bubbling Cauldron")));
    }

    public BogbrewWitch(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.CREATURE},"{3}{B}");
        this.subtype.add("Human");
        this.subtype.add("Wizard");

        this.power = new MageInt(1);
        this.toughness = new MageInt(3);

        // {2}, {T}: Search your library for a card named Festering Newt or Bubbling Cauldron, put it onto the battlefield tapped, then shuffle your library.
        TargetCardInLibrary target = new TargetCardInLibrary(1, 1, new FilterCard(filter));
        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD,
                new SearchLibraryPutInPlayEffect(target, true, true, Outcome.PutCardInPlay),
                new ManaCostsImpl("{2}"));
        ability.addCost(new TapSourceCost());
        this.addAbility(ability);


    }

    public BogbrewWitch(final BogbrewWitch card) {
        super(card);
    }

    @Override
    public BogbrewWitch copy() {
        return new BogbrewWitch(this);
    }
}
