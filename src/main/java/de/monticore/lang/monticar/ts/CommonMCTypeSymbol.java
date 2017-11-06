/**
 *
 *  ******************************************************************************
 *  MontiCAR Modeling Family, www.se-rwth.de
 *  Copyright (c) 2017, Software Engineering Group at RWTH Aachen,
 *  All rights reserved.
 *
 *  This project is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 3.0 of the License, or (at your option) any later version.
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this project. If not, see <http://www.gnu.org/licenses/>.
 * *******************************************************************************
 */
package de.monticore.lang.monticar.ts;

import com.google.common.collect.ImmutableList;
import de.monticore.symboltable.CommonScopeSpanningSymbol;
import de.monticore.symboltable.MutableScope;
import de.monticore.symboltable.modifiers.BasicAccessModifier;
import de.monticore.lang.monticar.ts.references.MCTypeReference;
import de.se_rwth.commons.logging.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;
import static de.monticore.symboltable.Symbols.sortSymbolsByPosition;

/**
 *
 * @author Pedram Mir Seyed Nazari
 * @param <T>
 * @param <S>
 */
public abstract class CommonMCTypeSymbol<T extends MCTypeSymbol, S extends MCFieldSymbol, U extends MCMethodSymbol, V extends MCTypeReference<T>>
        extends CommonScopeSpanningSymbol implements MCTypeSymbol {

    private final MCAttributeSymbolKind attributeKind;
    private final MCMethodSymbolKind methodKind;

    private V superClass;
    private final List<V> interfaces = new ArrayList<>();

    private boolean isAbstract = false;
    private boolean isFinal = false;
    private boolean isInterface = false;
    private boolean isEnum = false;
    private boolean isFormalTypeParameter = false;
    // e.g., inner interface or inner class
    private boolean isInnerType = false;

    protected CommonMCTypeSymbol(String name, MCTypeSymbolKind typeKind,
                                 MCAttributeSymbolKind attributeKind, MCMethodSymbolKind methodKind) {
        super(name, typeKind);

        this.attributeKind = attributeKind;
        this.methodKind = methodKind;
    }

    protected CommonMCTypeSymbol(String name) {
        this(name, MCTypeSymbol.KIND, MCFieldSymbol.KIND, MCMethodSymbol.KIND);
    }

    @Override
    protected MutableScope createSpannedScope() {
        return new CommonMCTypeScope(Optional.empty());
    }

    @Override
    public boolean isGeneric() {
        return !getFormalTypeParameters().isEmpty();
    }

    public void addFormalTypeParameter(T formalTypeParameter) {
        checkArgument(formalTypeParameter.isFormalTypeParameter());
        getMutableSpannedScope().add(formalTypeParameter);
    }

    @Override
    public List<T> getFormalTypeParameters() {
        final Collection<T> resolvedTypes = getSpannedScope().resolveLocally(T.KIND);
        return resolvedTypes.stream().filter(T::isFormalTypeParameter).collect(Collectors.toList());
    }

    @Override
    public Optional<V> getSuperClass() {
        return Optional.ofNullable(superClass);
    }

    public void setSuperClass(V superClass) {
        this.superClass = superClass;
    }

    @Override
    public List<V> getInterfaces() {
        return ImmutableList.copyOf(interfaces);
    }

    public void addInterface(V superInterface) {
        this.interfaces.add(Log.errorIfNull(superInterface));
    }

    @Override
    public List<V> getSuperTypes() {
        final List<V> superTypes = new ArrayList<>();
        if (getSuperClass().isPresent()) {
            superTypes.add(getSuperClass().get());
        }
        superTypes.addAll(getInterfaces());
        return superTypes;
    }

    public void addField(S attribute) {
        getMutableSpannedScope().add(Log.errorIfNull(attribute));
    }

    @Override
    public List<S> getFields() {
        return sortSymbolsByPosition(getSpannedScope().resolveLocally(attributeKind));
    }

    @Override
    public Optional<S> getField(String attributeName) {
        checkArgument(!isNullOrEmpty(attributeName));

        return getSpannedScope().resolveLocally(attributeName, attributeKind);
    }

    public void addMethod(U method) {
        Log.errorIfNull(method);
        checkArgument(!method.isConstructor());

        getMutableSpannedScope().add(method);
    }

    @Override
    public List<U> getMethods() {
        final Collection<U> resolvedMethods = getSpannedScope().resolveLocally(methodKind);

        final List<U> methods = sortSymbolsByPosition(resolvedMethods.stream().filter(method -> !method.isConstructor()).collect(Collectors.toList()));

        return methods;
    }

    @Override
    public Optional<U> getMethod(String methodName) {
        checkArgument(!isNullOrEmpty(methodName));

        Optional<U> method = getSpannedScope().resolveLocally(methodName, methodKind);
        if (method.isPresent() && !method.get().isConstructor()) {
            return method;
        }
        return Optional.empty();
    }

    public void addConstructor(U constructor) {
        Log.errorIfNull(constructor);
        checkArgument(constructor.isConstructor());

        getMutableSpannedScope().add(constructor);
    }

    @Override
    public List<U> getConstructors() {
        final Collection<U> resolvedMethods = getSpannedScope().resolveLocally(methodKind);

        final List<U> constructors = sortSymbolsByPosition(resolvedMethods.stream().filter(U::isConstructor).collect(Collectors.toList()));

        return constructors;
    }

    public void addInnerType(T innerType) {
        Log.errorIfNull(innerType);

        getMutableSpannedScope().add(innerType);
    }

    @Override
    public List<T> getInnerTypes() {
        return sortSymbolsByPosition(getSpannedScope().resolveLocally(getKind()));
    }

    @Override
    public Optional<T> getInnerType(String innerTypeName) {
        checkArgument(!isNullOrEmpty(innerTypeName));

        return getSpannedScope().resolveLocally(innerTypeName, getKind());
    }


    public void setAbstract(boolean isAbstract) {
        this.isAbstract = isAbstract;
    }

    @Override
    public boolean isAbstract() {
        return isAbstract;
    }

    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    @Override
    public boolean isFinal() {
        return isFinal;
    }

    public void setInterface(boolean isInterface) {
        this.isInterface = isInterface;
    }

    @Override
    public boolean isInterface() {
        return isInterface;
    }

    public void setEnum(boolean isEnum) {
        this.isEnum = isEnum;
    }

    @Override
    public boolean isEnum() {
        return isEnum;
    }

    @Override
    public boolean isClass() {
        return !isInterface() && !isEnum();
    }

    public void setPrivate() {
        setAccessModifier(BasicAccessModifier.PRIVATE);
    }

    public void setProtected() {
        setAccessModifier(BasicAccessModifier.PROTECTED);
    }

    public void setPublic() {
        setAccessModifier(BasicAccessModifier.PUBLIC);
    }

    @Override
    public boolean isPrivate() {
        return getAccessModifier().equals(BasicAccessModifier.PRIVATE);
    }

    @Override
    public boolean isProtected() {
        return getAccessModifier().equals(BasicAccessModifier.PROTECTED);
    }

    @Override
    public boolean isPublic() {
        return getAccessModifier().equals(BasicAccessModifier.PUBLIC);
    }

    public void setInnerType(boolean innerType) {
        isInnerType = innerType;
    }

    @Override
    public boolean isInnerType() {
        return isInnerType;
    }

    /**
     * @param formalTypeParameter true, if this type itself is a formal type parameter
     */
    public void setFormalTypeParameter(boolean formalTypeParameter) {
        this.isFormalTypeParameter = formalTypeParameter;
    }

    @Override
    public boolean isFormalTypeParameter() {
        return isFormalTypeParameter;
    }
}
